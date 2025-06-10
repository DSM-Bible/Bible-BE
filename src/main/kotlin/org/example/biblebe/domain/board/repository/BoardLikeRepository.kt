package org.example.biblebe.domain.board.repository

import org.example.biblebe.domain.board.entity.BoardEntity
import org.example.biblebe.domain.board.entity.BoardLikeEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.UUID

interface BoardLikeRepository : JpaRepository<BoardLikeEntity, UUID> {
    fun existsByBoardAndUser(board: BoardEntity, user: UserEntity): Boolean
    fun findByBoardAndUser(board: BoardEntity, user: UserEntity): BoardLikeEntity?
    fun countByBoard(board: BoardEntity): Int
    
    @Modifying
    @Query("DELETE FROM BoardLikeEntity bl WHERE bl.user = :user")
    fun deleteAllByUser(@Param("user") user: UserEntity)

    @Modifying
    @Query("DELETE FROM BoardLikeEntity bl WHERE bl.board = :board AND bl.user = :user")
    fun deleteByBoardAndUser(@Param("board") board: BoardEntity, @Param("user") user: UserEntity)
} 