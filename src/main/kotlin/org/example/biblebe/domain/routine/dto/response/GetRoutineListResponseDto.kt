package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*


data class GetRoutineListResponseDto(

        val data: List<GetRoutineListItemVO>,
) {
    companion object {
        fun from(routineEntities: List<RoutineEntity>): GetRoutineListResponseDto {
            return GetRoutineListResponseDto(
                    routineEntities.map { routine -> GetRoutineListItemVO.from(routine) }
                            .toList()
            )
        }
    }
}

data class GetRoutineListItemVO(

        val routineId: UUID,

        val title: String,

        val startTime: String,

        val endTime: String,
) {
    companion object {
        fun from(routineEntity: RoutineEntity): GetRoutineListItemVO {
            return GetRoutineListItemVO(
                    routineId = routineEntity.routineId!!,
                    title = routineEntity.name,
                    startTime = routineEntity.startTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                    endTime = routineEntity.endTime.format(DateTimeFormatter.ofPattern("HH:mm"))
            )
        }
    }
}