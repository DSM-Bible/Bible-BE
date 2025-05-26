package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import org.example.biblebe.domain.routine.service.CheckRoutineService
import org.example.biblebe.domain.routine.service.CommandRoutineHistoryService
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
@Transactional
class StartRoutineUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService,
    private val checkRoutineService: CheckRoutineService,
    private val commandRoutineHistoryService: CommandRoutineHistoryService
) {
    fun execute(routineId: UUID) {
        val user = currentUserProvider.getCurrentUser()
        val routine = getRoutineService.getRoutineById(routineId)

        checkRoutineService.checkIsOwnerOfRoutine(user, routine)

        commandRoutineHistoryService.saveRoutineHistory(RoutineHistoryEntity(
                routine = routine,
                startTime = LocalDateTime.now(),
        ))
    }
}