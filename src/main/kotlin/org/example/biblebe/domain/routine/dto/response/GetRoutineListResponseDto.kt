package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime
import java.util.*


data class GetRoutineListResponseDto(

    val routineId: UUID,

    val title: String,

    val startTime: LocalDateTime,

    val endTime: LocalDateTime,
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineListResponseDto {
            return GetRoutineListResponseDto(
                    routineId = routineEntity.routineId!!,
                    title = routineEntity.name,
                    startTime = routineEntity.startTime,
                    endTime = routineEntity.endTime
            )
        }
    }
}