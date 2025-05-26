package org.example.biblebe.domain.routine.dto.response

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import java.time.LocalDateTime

data class GetRoutineHistoryListDto(
    val data: List<RoutineHistoryListItem>
) {
    companion object {
        fun from(histories: List<RoutineHistoryEntity>): GetRoutineHistoryListDto {
            return GetRoutineHistoryListDto(
                    histories.map { history -> RoutineHistoryListItem.from(history) }
                            .toList()
            )
        }
    }
}

data class RoutineHistoryListItem(
        val title: String,
        val startTime: LocalDateTime,
        val endTime: LocalDateTime
) {
    companion object {
        fun from(routineHistoryEntity: RoutineHistoryEntity): RoutineHistoryListItem {
            return RoutineHistoryListItem(
                    routineHistoryEntity.routine.name,
                    routineHistoryEntity.startTime,
                    routineHistoryEntity.endTime!!
            )
        }
    }
}
