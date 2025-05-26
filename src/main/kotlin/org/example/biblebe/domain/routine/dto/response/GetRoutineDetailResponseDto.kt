package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class GetRoutineDetailResponseDto(
    val title: String,

    val repeatPeriod: RepeatPeriod,

    val startTime: String,

    val endTime: String
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineDetailResponseDto {
            return GetRoutineDetailResponseDto(
                    routineEntity.name,
                    routineEntity.repeatPeriod,
                    routineEntity.startTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                    routineEntity.endTime.format(DateTimeFormatter.ofPattern("HH:mm")),
            )
        }
    }
}