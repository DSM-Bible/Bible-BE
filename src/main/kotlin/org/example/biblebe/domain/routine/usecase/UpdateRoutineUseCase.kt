package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.request.UpdateRoutineRequestDto
import org.example.biblebe.domain.routine.service.CheckRoutineService
import org.example.biblebe.domain.routine.service.CommandRoutineService
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class UpdateRoutineUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService,
    private val checkRoutineService: CheckRoutineService,
    private val commandRoutineService: CommandRoutineService
) {
    fun execute(routineId: UUID, request: UpdateRoutineRequestDto) {
        val user = currentUserProvider.getCurrentUser()
        val routine = getRoutineService.getRoutineById(routineId)

        checkRoutineService.checkIsOwnerOfRoutine(user, routine)

        routine.name = request.title
        routine.startTime = request.startTime
        routine.endTime = request.endTime
        commandRoutineService.saveRoutine(routine)
    }
}