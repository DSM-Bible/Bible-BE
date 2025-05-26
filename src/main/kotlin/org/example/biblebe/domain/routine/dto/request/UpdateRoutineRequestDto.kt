package org.example.biblebe.domain.routine.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.hibernate.validator.constraints.Length
import java.time.LocalTime

data class UpdateRoutineRequestDto(
        @field:Length(min = 1, max = 200)
        val title: String?,

        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        val startTime: LocalTime?,

        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        val endTime: LocalTime?,

        val repeatPeriod: RepeatPeriod?
) {
}