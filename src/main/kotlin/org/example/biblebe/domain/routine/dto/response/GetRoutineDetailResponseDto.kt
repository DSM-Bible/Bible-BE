package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime

data class GetRoutineDetailResponseDto(
    val title: String,

    val startTime: LocalDateTime,

    val endTime: LocalDateTime
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineDetailResponseDto {
            return GetRoutineDetailResponseDto(
                    routineEntity.name,
                    routineEntity.startTime,
                    routineEntity.endTime,
            )
        }
    }
}