package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.request.CreateRoutineRequestDto
import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.service.CommandRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateRoutineUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val commandRoutineService: CommandRoutineService
) {
    fun execute(request: CreateRoutineRequestDto) {
        val user = currentUserProvider.getCurrentUser()

        commandRoutineService.saveRoutine(RoutineEntity(
            null,
            user,
            request.title,
            request.startTime,
            request.endTime
        ))
    }
}