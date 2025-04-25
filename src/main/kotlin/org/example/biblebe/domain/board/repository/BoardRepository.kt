package org.example.biblebe.domain.board.repository

import org.example.biblebe.domain.board.entity.BoardEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoardRepository : JpaRepository<BoardEntity, UUID> {
    fun findAllByUser(user: UserEntity, pageable: Pageable): Page<BoardEntity>
    fun findAllByTitleContainingOrContentContaining(title: String, content: String, pageable: Pageable): Page<BoardEntity>
} 