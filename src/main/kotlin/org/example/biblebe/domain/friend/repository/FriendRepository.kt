package org.example.biblebe.domain.friend.repository

import org.example.biblebe.domain.friend.entity.FriendEntity
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface FriendRepository : CrudRepository<FriendEntity, UUID> {

    @Modifying
    @Query("INSERT INTO FriendEntity (user, friend, isAccept) VALUES (:#{#friend.user}, :#{#friend.friend}, :#{#friend.isAccept})")
    fun save(friend: FriendEntity)

    @Modifying
    @Query("UPDATE FriendEntity f SET f.isAccept = :isAccept WHERE f.id = :id")
    fun updateFriendAcceptStatus(@Param("id") id: UUID, @Param("isAccept") isAccept: Boolean)

    fun findAllByUser(user: UserEntity): List<FriendEntity>
    fun findAllByFriend(user: UserEntity): List<FriendEntity>
    fun findAllByUserAndIsAcceptTrue(user: UserEntity): List<FriendEntity>
    fun findByUserAndFriend(user: UserEntity, friend: UserEntity): FriendEntity?
} 