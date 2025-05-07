package org.example.biblebe.domain.friend.dto

data class UserListResponse(
    val user: List<UserResponse>
)

data class UserResponse(
    val userId: String,
    val userName: String,
    val imageUrl: String?
) 