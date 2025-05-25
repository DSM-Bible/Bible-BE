package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.service.CommandRoutineService
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class DeleteRoutineUseCase(
    private val getRoutineService: GetRoutineService,
    private val commandRoutineService: CommandRoutineService
) {
    fun execute(routineId: UUID) {
        val routine = getRoutineService.getRoutineById(routineId)
        commandRoutineService.deleteRoutine(routine)
    }
}