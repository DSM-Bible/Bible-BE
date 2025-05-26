package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineHistoryEntity
import org.example.biblebe.domain.routine.exception.RoutineIsAlreadyEndedException
import org.example.biblebe.domain.routine.service.CheckRoutineHistoryService
import org.springframework.stereotype.Service

@Service
class CheckRoutineHistoryServiceImpl: CheckRoutineHistoryService {
    override fun checkRoutineIsNotEnd(routineHistoryEntity: RoutineHistoryEntity) {
        if (routineHistoryEntity.isEnd!!) {
            throw RoutineIsAlreadyEndedException
        }
    }
}