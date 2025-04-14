package org.example.biblebe.domain.friend.service

interface FriendAddDeleteService {
    fun addFriend(friendId: String)
    fun deleteFriend(friendId: String)
    fun setFriendUserTrue(friendId: String)
}