package org.example.biblebe.domain.board.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "board")
class BoardEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @Column
    val fileUrl: String? = null,

    val timestamp: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    var likeCount: Int = 0
) 