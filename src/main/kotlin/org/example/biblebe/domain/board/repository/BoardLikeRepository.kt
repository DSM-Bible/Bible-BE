package org.example.biblebe.domain.board.repository

import org.example.biblebe.domain.board.entity.BoardEntity
import org.example.biblebe.domain.board.entity.BoardLikeEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoardLikeRepository : JpaRepository<BoardLikeEntity, UUID> {
    fun existsByBoardAndUser(board: BoardEntity, user: UserEntity): Boolean
    fun findByBoardAndUser(board: BoardEntity, user: UserEntity): BoardLikeEntity?
    fun countByBoard(board: BoardEntity): Int
} 