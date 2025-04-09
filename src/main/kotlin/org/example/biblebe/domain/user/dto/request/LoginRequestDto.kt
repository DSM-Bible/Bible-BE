package org.example.biblebe.domain.user.dto.request

import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull

data class LoginRequestDto (
        @field:NotNull
        @field:Length(max = 15, min = 8)
        val id: String,

        @field:NotNull
        @field:Length(max = 15, min = 8)
        val password: String
)