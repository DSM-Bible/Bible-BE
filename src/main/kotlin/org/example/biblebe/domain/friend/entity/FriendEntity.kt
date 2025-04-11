package org.example.biblebe.domain.friend.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import java.util.UUID

@Entity
@Table(name = "friend")
class FriendEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id", nullable = false)
    val friend: UserEntity,

    val isAccept: Boolean
) 