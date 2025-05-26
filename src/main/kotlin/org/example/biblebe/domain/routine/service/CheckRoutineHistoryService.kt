package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity

interface CheckRoutineHistoryService {
    fun checkRoutineIsNotEnd(routineHistoryEntity: RoutineHistoryEntity)
}