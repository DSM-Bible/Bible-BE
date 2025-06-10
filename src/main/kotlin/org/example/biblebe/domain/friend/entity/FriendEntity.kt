package org.example.biblebe.domain.friend.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.UUID

@Entity
@Table(name = "friend")
class FriendEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val friend: UserEntity,

    var isAccept: Boolean,
    
    @Version
    var version: Long = 0
) 