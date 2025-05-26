package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.user.entity.UserEntity

interface CheckRoutineService {
    fun checkIsOwnerOfRoutine(user: UserEntity, routine: RoutineEntity)
}