package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.response.GetRoutineDetailResponseDto
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(readOnly = true)
class GetRoutineDetailUseCase(
    private val getRoutineService: GetRoutineService
) {
    fun execute(routineId: UUID): GetRoutineDetailResponseDto {
        val routine = getRoutineService.getRoutineById(routineId)
        return GetRoutineDetailResponseDto.from(routine)
    }
}