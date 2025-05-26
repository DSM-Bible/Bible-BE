package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.service.CheckRoutineService
import org.example.biblebe.domain.routine.service.CommandRoutineHistoryService
import org.example.biblebe.domain.routine.service.GetRoutineHistoryService
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.domain.routine.service.impl.CheckRoutineHistoryServiceImpl
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class EndRoutineUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService,
    private val getRoutineHistoryService: GetRoutineHistoryService,
    private val checkRoutineService: CheckRoutineService,
    private val checkRoutineHistoryServiceImpl: CheckRoutineHistoryServiceImpl,
    private val commandRoutineHistoryService: CommandRoutineHistoryService
) {
    fun execute(routineId: UUID) {
        val user = currentUserProvider.getCurrentUser()
        val routine = getRoutineService.getRoutineById(routineId)
        val routineHistory = getRoutineHistoryService.getRoutineHistoryByRoutine(routine)

        checkRoutineService.checkIsOwnerOfRoutine(user, routineHistory.routine)
        checkRoutineHistoryServiceImpl.checkRoutineIsNotEnd(routineHistory)

        commandRoutineHistoryService.deleteRoutineHistory(routineHistory)
    }
}