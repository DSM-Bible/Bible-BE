package org.example.biblebe.domain.user.dto.request

import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

data class UpdateUserProfileRequestDto(
        @field:NotNull
        @field:Length(max = 8, min = 1)
        val nickname: String
)
