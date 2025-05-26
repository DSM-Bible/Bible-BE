package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.exception.NotOwnerOfRoutineException
import org.example.biblebe.domain.routine.service.CheckRoutineService
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.stereotype.Service

@Service
class CheckRoutineServiceImpl: CheckRoutineService {
    override fun checkIsOwnerOfRoutine(user: UserEntity, routine: RoutineEntity) {
        if (!routine.user.userId.equals(user.userId)) {
            throw NotOwnerOfRoutineException
        }
    }
}