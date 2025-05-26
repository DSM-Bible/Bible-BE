package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import org.example.biblebe.domain.routine.entity.RoutineHistoryJpaRepository
import org.example.biblebe.domain.routine.service.CommandRoutineHistoryService
import org.springframework.stereotype.Service

@Service
class CommandRoutineHistoryServiceImpl(
    private val routineHistoryJpaRepository: RoutineHistoryJpaRepository
): CommandRoutineHistoryService {

    override fun saveRoutineHistory(routineHistoryEntity: RoutineHistoryEntity) {
        routineHistoryJpaRepository.save(routineHistoryEntity)
    }
}