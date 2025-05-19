package org.example.biblebe.domain.board.dto

import org.example.biblebe.domain.board.entity.BoardEntity
import java.time.LocalDateTime
import java.util.UUID

data class BoardResponse(
    val id: UUID,
    val title: String,
    val content: String,
    val userId: String,
    val userName: String,
    val fileUrl: String?,
    val likeCount: Int,
    val isLiked: Boolean = false
) {
    companion object {
        fun fromEntity(boardEntity: BoardEntity, isLiked: Boolean = false): BoardResponse {
            return BoardResponse(
                id = boardEntity.id,
                title = boardEntity.title,
                content = boardEntity.content,
                userId = boardEntity.user.userId,
                userName = boardEntity.user.nickname,
                fileUrl = boardEntity.fileUrl,
                likeCount = boardEntity.likeCount,
                isLiked = isLiked
            )
        }
    }
}

data class BoardFileResponse(
    val id: UUID,
    val originalFileName: String,
    val fileUrl: String,
    val fileSize: Long
) 