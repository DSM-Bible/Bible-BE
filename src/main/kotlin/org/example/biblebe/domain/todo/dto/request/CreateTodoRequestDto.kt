package org.example.biblebe.domain.todo.dto.request

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class CreateTodoRequestDto(
        @field:NotBlank
        @field:Length(min = 1, max = 200)
        val title: String,

        @field:NotNull
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        val startTime: LocalDate,

        @field:NotNull
        val remind: Int
)
