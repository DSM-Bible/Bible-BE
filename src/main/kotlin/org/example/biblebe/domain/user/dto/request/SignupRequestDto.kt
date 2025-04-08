package org.example.biblebe.domain.user.dto.request

import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

data class SignupRequestDto(
        @field:NotNull
        @field:Length(max = 15, min = 8)
        val id: String,

        @field:NotNull
        @field:Length(max = 8, min = 1)
        val nickname: String,

        @field:NotNull
        @field:Length(max = 15, min = 8)
        val password: String
)
