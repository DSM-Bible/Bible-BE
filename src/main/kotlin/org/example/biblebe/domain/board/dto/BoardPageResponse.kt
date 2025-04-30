package org.example.biblebe.domain.board.dto

import org.example.biblebe.domain.board.entity.BoardEntity
import org.springframework.data.domain.Page
import java.time.LocalDateTime
import java.util.UUID

data class BoardPageResponse(
    val id: UUID,
    val title: String,
    val userId: String,
    val userName: String,
    val fileUrl: String?,
) {
    companion object {
        fun fromEntity(boardEntity: BoardEntity): BoardPageResponse {
            return BoardPageResponse(
                id = boardEntity.id,
                title = boardEntity.title,
                userId = boardEntity.user.userId,
                userName = boardEntity.user.nickname,
                fileUrl = boardEntity.fileUrl
            )
        }
    }
}

data class BoardListResponse(
    val content: List<BoardPageResponse>,
    val totalPages: Int,
    val totalElements: Long,
    val size: Int,
    val number: Int,
    val first: Boolean,
    val last: Boolean
) {
    companion object {
        fun fromPage(page: Page<BoardPageResponse>): BoardListResponse {
            return BoardListResponse(
                content = page.content,
                totalPages = page.totalPages,
                totalElements = page.totalElements,
                size = page.size,
                number = page.number,
                first = page.isFirst,
                last = page.isLast
            )
        }
    }
} 