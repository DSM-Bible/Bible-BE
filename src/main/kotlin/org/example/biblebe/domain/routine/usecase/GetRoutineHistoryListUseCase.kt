package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.response.GetRoutineHistoryListDto
import org.example.biblebe.domain.routine.service.GetRoutineHistoryService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetRoutineHistoryListUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineHistoryService: GetRoutineHistoryService
) {
    fun execute(): GetRoutineHistoryListDto {
        val user = currentUserProvider.getCurrentUser()
        val routineHistories = getRoutineHistoryService.getEndedRoutineHistoryByUser(user)

        return GetRoutineHistoryListDto.from(routineHistories)
    }
}