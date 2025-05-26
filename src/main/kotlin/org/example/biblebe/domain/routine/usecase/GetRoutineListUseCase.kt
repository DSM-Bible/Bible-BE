package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.response.GetRoutineListResponseDto
import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetRoutineListUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService
) {
    fun execute(): GetRoutineListResponseDto {
        val routines = getRoutineService.getTodayRoutineList(currentUserProvider.getCurrentUser())
        return GetRoutineListResponseDto.from(routines)
    }
}