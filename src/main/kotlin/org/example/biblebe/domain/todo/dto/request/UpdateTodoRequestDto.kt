package org.example.biblebe.domain.todo.dto.request

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime

data class UpdateTodoRequestDto(
        @field:NotBlank
        @field:Length(min = 1, max = 200)
        val title: String?,

        @field:NotNull
        @field:DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
        val startTime: LocalDateTime?,

        @field:NotNull
        val remind: Int?
)
