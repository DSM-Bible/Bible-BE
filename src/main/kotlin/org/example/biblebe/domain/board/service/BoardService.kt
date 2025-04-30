package org.example.biblebe.domain.board.service

import org.example.biblebe.domain.board.dto.BoardListResponse
import org.example.biblebe.domain.board.dto.BoardRequest
import org.example.biblebe.domain.board.dto.BoardResponse
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

interface BoardService {
    fun createBoard(request: BoardRequest, file: MultipartFile?): BoardResponse
    fun getBoardById(boardId: UUID): BoardResponse
    fun getBoards(pageable: Pageable): BoardListResponse
    fun searchBoards(keyword: String, pageable: Pageable): BoardListResponse
    fun updateBoard(boardId: UUID, request: BoardRequest, file: MultipartFile?): BoardResponse
    fun deleteBoard(boardId: UUID)
} 