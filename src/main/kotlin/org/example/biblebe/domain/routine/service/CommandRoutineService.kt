package org.example.biblebe.domain.routine.service

import org.example.biblebe.domain.routine.entity.RoutineEntity

interface CommandRoutineService {

    fun saveRoutine(routineEntity: RoutineEntity)

    fun deleteRoutine(routineEntity: RoutineEntity)
}