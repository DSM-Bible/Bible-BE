package org.example.biblebe.domain.friend.repository

import org.example.biblebe.domain.friend.entity.FriendEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FriendRepository : JpaRepository<FriendEntity, UUID> {
    fun findAllByUser(user: UserEntity): List<FriendEntity>
    fun findAllByUserAndIsAcceptTrue(user: UserEntity): List<FriendEntity>
    fun findByUserAndFriend(user: UserEntity, friend: UserEntity): FriendEntity?
} 