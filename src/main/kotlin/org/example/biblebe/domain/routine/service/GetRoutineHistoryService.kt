package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import java.util.*

interface GetRoutineHistoryService {
    fun getRoutineHistoryById(routineId: UUID): RoutineHistoryEntity

    fun getRoutineHistoryByRoutine(routine: RoutineEntity): RoutineHistoryEntity
}