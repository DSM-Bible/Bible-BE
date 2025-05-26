package org.example.biblebe.domain.routine.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.LocalTime

data class UpdateRoutineRequestDto(
        @field:Length(min = 1, max = 200)
        val title: String,

        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        val startTime: LocalTime,

        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        val endTime: LocalTime,

        val repeatPeriod: RepeatPeriod
) {
}