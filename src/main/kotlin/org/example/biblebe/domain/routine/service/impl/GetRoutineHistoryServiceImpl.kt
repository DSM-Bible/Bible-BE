package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import org.example.biblebe.domain.routine.entity.RoutineHistoryJpaRepository
import org.example.biblebe.domain.routine.exception.RoutineHistoryNotFoundException
import org.example.biblebe.domain.routine.service.GetRoutineHistoryService
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetRoutineHistoryServiceImpl(
    private val routineHistoryJpaRepository: RoutineHistoryJpaRepository
): GetRoutineHistoryService {
    override fun getRoutineHistoryById(routineId: UUID): RoutineHistoryEntity {
        return routineHistoryJpaRepository.findById(routineId)
                .orElseThrow { RoutineHistoryNotFoundException }
    }

    override fun getRoutineHistoryByRoutine(routine: RoutineEntity): RoutineHistoryEntity {
        return routineHistoryJpaRepository.findByRoutineAndIsEnd(routine, false)
                .orElseThrow { RoutineHistoryNotFoundException }
    }

    override fun getEndedRoutineHistoryByUser(user: UserEntity): List<RoutineHistoryEntity> {
        return routineHistoryJpaRepository.findAllEndedRoutineHistoryByUser(user)
    }
}