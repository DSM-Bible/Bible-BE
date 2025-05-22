package org.example.biblebe.domain.user.dto.response

data class GetUserResponseDto (
    val userId: String,
    val nickname: String,
    val profile: String
)