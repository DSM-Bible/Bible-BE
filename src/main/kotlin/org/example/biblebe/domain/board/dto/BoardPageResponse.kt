package org.example.biblebe.domain.board.dto

import org.example.biblebe.domain.board.entity.BoardEntity
import org.springframework.data.domain.Page
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class BoardPageResponse(
    val id: UUID,
    val title: String,
    val userId: String,
    val userName: String,
    val fileUrl: String?,
    val timestamp: LocalDate?,
    val likeCount: Int,
) {
    companion object {
        fun fromEntity(boardEntity: BoardEntity, isLiked: Boolean = false): BoardPageResponse {
            return BoardPageResponse(
                id = boardEntity.id,
                title = boardEntity.title,
                userId = boardEntity.user.userId,
                userName = boardEntity.user.nickname,
                fileUrl = boardEntity.fileUrl,
                timestamp = boardEntity.timestamp,
                likeCount = boardEntity.likeCount,
            )
        }
    }
}

data class BoardListResponse(
    val list: List<BoardPageResponse>,
) {
    constructor() : this(listOf())
} 