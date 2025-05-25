package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineEntity
import java.util.*

interface GetRoutineService {
    fun getRoutineById(id: UUID): RoutineEntity
}