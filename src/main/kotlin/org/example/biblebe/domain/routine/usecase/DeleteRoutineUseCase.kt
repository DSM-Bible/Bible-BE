package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.service.CheckRoutineService
import org.example.biblebe.domain.routine.service.CommandRoutineService
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class DeleteRoutineUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService,
    private val commandRoutineService: CommandRoutineService,
    private val checkRoutineService: CheckRoutineService
) {
    fun execute(routineId: UUID) {
        val routine = getRoutineService.getRoutineById(routineId)
        val user = currentUserProvider.getCurrentUser()

        checkRoutineService.checkIsOwnerOfRoutine(user, routine)

        commandRoutineService.deleteRoutine(routine)
    }
}