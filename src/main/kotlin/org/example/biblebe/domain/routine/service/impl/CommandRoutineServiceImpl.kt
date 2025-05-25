package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.entity.RoutineJpaRepository
import org.example.biblebe.domain.routine.service.CommandRoutineService
import org.springframework.stereotype.Component

@Component
class CommandRoutineServiceImpl(
    private val routineJpaRepository: RoutineJpaRepository
): CommandRoutineService {

    override fun saveRoutine(routineEntity: RoutineEntity) {
        routineJpaRepository.save(routineEntity)
    }
}