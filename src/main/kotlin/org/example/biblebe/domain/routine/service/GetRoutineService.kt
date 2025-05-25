package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.user.entity.UserEntity
import java.util.*

interface GetRoutineService {
    fun getRoutineById(id: UUID): RoutineEntity

    fun getTodayRoutineList(user: UserEntity): List<RoutineEntity>
}