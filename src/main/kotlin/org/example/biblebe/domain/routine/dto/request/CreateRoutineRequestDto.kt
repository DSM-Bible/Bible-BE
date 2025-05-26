package org.example.biblebe.domain.routine.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import java.time.LocalTime

data class CreateRoutineRequestDto(
        @field:NotBlank
        @field:Length(min = 1, max = 200)
        val title: String,

        @field:NotNull
        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        val startTime: LocalTime,

        @field:NotNull
        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        val endTime: LocalTime,

        val repeatPeriod: RepeatPeriod
) {
}