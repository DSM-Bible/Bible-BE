package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.entity.RoutineJpaRepository
import org.example.biblebe.domain.routine.exception.RoutineNotFoundException
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetRoutineServiceImpl (
    private val routineJpaRepository: RoutineJpaRepository
): GetRoutineService {
    override fun getRoutineById(id: UUID): RoutineEntity {
        return routineJpaRepository.findById(id)
                .orElseThrow { RoutineNotFoundException }
    }
}