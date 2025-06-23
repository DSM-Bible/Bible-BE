package org.example.biblebe.domain.board.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.board.dto.BoardListResponse
import org.example.biblebe.domain.board.dto.BoardRequest
import org.example.biblebe.domain.board.dto.BoardResponse
import org.example.biblebe.domain.board.service.BoardService
import org.example.biblebe.global.ApiResponse
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RestController
@RequestMapping("/board")
class BoardController(
    private val boardService: BoardService
) {
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createBoard(
        @RequestPart("request") @Valid request: BoardRequest,
        @RequestPart("file", required = false) file: MultipartFile?
    ): ApiResponse<BoardResponse> {
        val response = boardService.createBoard(request, file)
        return ApiResponse(
            status = "200 OK",
            message = "게시글이 성공적으로 등록되었습니다.",
            data = response
        )
    }

    @GetMapping("/{boardId}")
    fun getBoard(@PathVariable boardId: UUID): ApiResponse<BoardResponse> {
        val response = boardService.getBoardById(boardId)
        return ApiResponse(
            status = "200 OK",
            message = "게시글 조회에 성공했습니다.",
            data = response
        )
    }

    @GetMapping("/list")
    fun getBoards(
        @RequestParam selectType: Int = 1
    ): ApiResponse<BoardListResponse> {
        val response = when(selectType) {
            1 -> boardService.getBoards()
            2 -> boardService.getFriendBoards()
            else -> boardService.getBoards()
        }
        return ApiResponse(
            status = "200 OK",
            message = if (selectType == 2) "친구의 게시글 목록 조회에 성공했습니다." else "게시글 목록 조회에 성공했습니다.",
            data = response
        )
    }

    @GetMapping("/search")
    fun searchBoards(
        @RequestParam keyword: String
    ): ApiResponse<BoardListResponse> {
        val response = boardService.searchBoards(keyword)
        return ApiResponse(
            status = "200 OK",
            message = "게시글 검색에 성공했습니다.",
            data = response
        )
    }

    @PatchMapping(value = ["/edit/{boardId}"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun updateBoard(
        @PathVariable boardId: UUID,
        @RequestPart("request") @Valid request: BoardRequest,
        @RequestPart("file", required = false) file: MultipartFile?
    ): ApiResponse<BoardResponse> {
        val response = boardService.updateBoard(boardId, request, file)
        return ApiResponse(
            status = "200 OK",
            message = "게시글이 성공적으로 수정되었습니다.",
            data = response
        )
    }

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable boardId: UUID): ApiResponse<Unit> {
        boardService.deleteBoard(boardId)
        return ApiResponse(
            status = "200 OK",
            message = "게시글이 성공적으로 삭제되었습니다.",
            data = Unit
        )
    }
    
    @PostMapping("/{boardId}/like")
    fun likeBoard(@PathVariable boardId: UUID): ApiResponse<BoardResponse> {
        val response = boardService.likeBoard(boardId)
        return ApiResponse(
            status = "200 OK",
            message = "게시글에 좋아요를 성공적으로 등록했습니다.",
            data = response
        )
    }
    
    @DeleteMapping("/{boardId}/like")
    fun unlikeBoard(@PathVariable boardId: UUID): ApiResponse<BoardResponse> {
        val response = boardService.unlikeBoard(boardId)
        return ApiResponse(
            status = "200 OK",
            message = "게시글 좋아요를 성공적으로 취소했습니다.",
            data = response
        )
    }
    
    @GetMapping("/{boardId}/like")
    fun getLikeStatus(@PathVariable boardId: UUID): ApiResponse<Map<String, Boolean>> {
        val isLiked = boardService.getLikeStatus(boardId)
        return ApiResponse(
            status = "200 OK",
            message = "좋아요 상태 조회에 성공했습니다.",
            data = mapOf("isLiked" to isLiked)
        )
    }
} 