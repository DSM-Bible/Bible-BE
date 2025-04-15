package org.example.biblebe.domain.friend.dto

data class FriendResponse(
    val friend_id: String,
    val friend_name: String,
    val image_url: String,
    val is_accepted: Boolean
)
