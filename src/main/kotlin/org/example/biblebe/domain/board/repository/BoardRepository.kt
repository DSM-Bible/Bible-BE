package org.example.biblebe.domain.board.repository

import org.example.biblebe.domain.board.entity.BoardEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.UUID

interface BoardRepository : JpaRepository<BoardEntity, UUID> {
    fun findAllByUser(user: UserEntity, pageable: Pageable): Page<BoardEntity>
    fun findAllByTitleContainingOrContentContaining(title: String, content: String,): List<BoardEntity>
    
    @Query("""
        SELECT b FROM BoardEntity b 
        WHERE b.user IN (
            SELECT f.friend FROM FriendEntity f 
            WHERE f.user = :user AND f.isAccept = true
            UNION
            SELECT f.user FROM FriendEntity f 
            WHERE f.friend = :user AND f.isAccept = true
        )
        ORDER BY b.timestamp DESC
    """)
    fun findAllByFriends(@Param("user") user: UserEntity): List<BoardEntity>
} 