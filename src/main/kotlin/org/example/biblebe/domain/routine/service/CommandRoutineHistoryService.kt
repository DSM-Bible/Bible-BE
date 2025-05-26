package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity

interface CommandRoutineHistoryService {
    fun saveRoutineHistory(routineHistoryEntity: RoutineHistoryEntity)

    fun deleteRoutineHistory(routineHistory: RoutineHistoryEntity)
}