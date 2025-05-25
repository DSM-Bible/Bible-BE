package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime


data class GetRoutineListResponseDto(

        val title: String,

        val startTime: LocalDateTime,

        val endTime: LocalDateTime,
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineListResponseDto {
            return GetRoutineListResponseDto(
                    title = routineEntity.name,
                    startTime = routineEntity.startTime,
                    endTime = routineEntity.endTime
            )
        }
    }
}