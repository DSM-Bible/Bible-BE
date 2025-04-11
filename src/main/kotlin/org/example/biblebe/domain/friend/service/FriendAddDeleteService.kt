package org.example.biblebe.domain.friend.service

interface FriendAddDeleteService {
    fun addFriend(friendId: String)
    fun deleteFriend(friendId: String)
}