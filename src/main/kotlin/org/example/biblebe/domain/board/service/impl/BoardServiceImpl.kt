package org.example.biblebe.domain.board.service.impl

import org.example.biblebe.domain.board.dto.*
import org.example.biblebe.domain.board.entity.BoardEntity
import org.example.biblebe.domain.board.exception.BoardErrorCode
import org.example.biblebe.domain.board.exception.BoardException
import org.example.biblebe.domain.board.repository.BoardRepository
import org.example.biblebe.domain.board.service.BoardService
import org.example.biblebe.global.service.CurrentUserProvider
import org.example.biblebe.global.thirdparty.s3.FileService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.util.UUID

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository,
    private val currentUserProvider: CurrentUserProvider,
    private val fileService: FileService
) : BoardService {

    @Transactional
    override fun createBoard(request: BoardRequest, file: MultipartFile?): BoardResponse {
        val currentUser = currentUserProvider.getCurrentUser()

        val boardEntity = if (file != null && !file.isEmpty) {
            try {
                // S3에 파일 업로드
                val fileUrl = fileService.uploadFile(file)
                
                BoardEntity(
                    title = request.title,
                    content = request.content,
                    user = currentUser,
                    fileUrl = fileUrl
                )
            } catch (e: Exception) {
                throw BoardException(BoardErrorCode.FILE_UPLOAD_ERROR)
            }
        } else {
            BoardEntity(
                title = request.title,
                content = request.content,
                user = currentUser
            )
        }

        val savedBoard = boardRepository.save(boardEntity)
        return BoardResponse.fromEntity(savedBoard)
    }

    @Transactional(readOnly = true)
    override fun getBoardById(boardId: UUID): BoardResponse {
        val board = boardRepository.findById(boardId)
            .orElseThrow { BoardException(BoardErrorCode.BOARD_NOT_FOUND) }

        return BoardResponse.fromEntity(board)
    }

    @Transactional(readOnly = true)
    override fun getBoards(pageable: Pageable): BoardListResponse {
        val boardsPage = boardRepository.findAll(pageable)
        
        val boardResponses = boardsPage.map { board ->
            BoardPageResponse.fromEntity(board)
        }

        return BoardListResponse.fromPage(boardResponses)
    }

    @Transactional(readOnly = true)
    override fun searchBoards(keyword: String, pageable: Pageable): BoardListResponse {
        val boardsPage = boardRepository.findAllByTitleContainingOrContentContaining(keyword, keyword, pageable)
        
        val boardResponses = boardsPage.map { board ->
            BoardPageResponse.fromEntity(board)
        }

        return BoardListResponse.fromPage(boardResponses)
    }

    @Transactional
    override fun updateBoard(boardId: UUID, request: BoardRequest, file: MultipartFile?): BoardResponse {
        val currentUser = currentUserProvider.getCurrentUser()
        val board = boardRepository.findById(boardId)
            .orElseThrow { BoardException(BoardErrorCode.BOARD_NOT_FOUND) }

        // 권한 체크: 게시글 작성자만 수정할 수 있음
        if (board.user.userId != currentUser.userId) {
            throw BoardException(BoardErrorCode.NOT_BOARD_OWNER)
        }

        // 새 파일 처리와 게시글 업데이트
        val updatedBoard = if (file != null && !file.isEmpty) {
            try {
                // S3에 파일 업로드
                val fileUrl = fileService.uploadFile(file)
                
                BoardEntity(
                    id = board.id,
                    title = request.title,
                    content = request.content,
                    user = board.user,
                    fileUrl = fileUrl,
                )
            } catch (e: Exception) {
                throw BoardException(BoardErrorCode.FILE_UPLOAD_ERROR)
            }
        } else {
            BoardEntity(
                id = board.id,
                title = request.title,
                content = request.content,
                user = board.user,
                fileUrl = board.fileUrl, // 기존 파일 URL 유지
            )
        }

        val savedBoard = boardRepository.save(updatedBoard)
        return BoardResponse.fromEntity(savedBoard)
    }

    @Transactional
    override fun deleteBoard(boardId: UUID) {
        val currentUser = currentUserProvider.getCurrentUser()
        val board = boardRepository.findById(boardId)
            .orElseThrow { BoardException(BoardErrorCode.BOARD_NOT_FOUND) }

        // 권한 체크: 게시글 작성자만 삭제할 수 있음
        if (board.user.userId != currentUser.userId) {
            throw BoardException(BoardErrorCode.NOT_BOARD_OWNER)
        }
        
        // 게시글 삭제
        boardRepository.delete(board)
    }
} 