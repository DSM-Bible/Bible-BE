package org.example.biblebe.domain.routine.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class GetRoutineListRequestDto(
        @field:NotNull
        @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd")
        val date: LocalDate,
) {
}