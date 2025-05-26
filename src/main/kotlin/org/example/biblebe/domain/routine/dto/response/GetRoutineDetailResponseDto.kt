package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime
import java.time.LocalTime

data class GetRoutineDetailResponseDto(
    val title: String,

    val repeatPeriod: RepeatPeriod,

    val startTime: LocalTime,

    val endTime: LocalTime
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineDetailResponseDto {
            return GetRoutineDetailResponseDto(
                    routineEntity.name,
                    routineEntity.repeatPeriod,
                    routineEntity.startTime,
                    routineEntity.endTime,
            )
        }
    }
}