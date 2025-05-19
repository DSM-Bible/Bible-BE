package org.example.biblebe.domain.board.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "board_like",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["board_id", "user_id"])
    ]
)
class BoardLikeEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    val board: BoardEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
) 