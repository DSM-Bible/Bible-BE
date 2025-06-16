package org.example.biblebe.domain.routine.usecase

import org.example.biblebe.domain.routine.dto.response.GetRoutineListResponseDto
import org.example.biblebe.domain.routine.entity.RepeatPeriod
import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.ArrayList

@Service
@Transactional(readOnly = true)
class GetRoutineListUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getRoutineService: GetRoutineService
) {
    fun execute(date: LocalDate): GetRoutineListResponseDto {
        val user = currentUserProvider.getCurrentUser()
        val routines = getRoutineService.getRoutinesByUser(user)

        val filteredRoutines = ArrayList<RoutineEntity>()
        for (routine in routines) {
            val betweenDays = ChronoUnit.DAYS.between(routine.createdAt, date).toInt()

            if (!routine.createdAt!!.isAfter(date)) {
                if (routine.repeatPeriod == RepeatPeriod.EVERY_MONTH) {
                    if (routine.createdAt!!.dayOfMonth == date.dayOfMonth) {
                        filteredRoutines.add(routine)
                    }
                } else if (betweenDays % routine.repeatPeriod.days == 0) {
                    filteredRoutines.add(routine)
                }
            }
        }

        return GetRoutineListResponseDto.from(filteredRoutines)
    }
}