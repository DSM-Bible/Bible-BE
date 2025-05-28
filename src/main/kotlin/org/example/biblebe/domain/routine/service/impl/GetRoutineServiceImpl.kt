package org.example.biblebe.domain.routine.service.impl

import org.example.biblebe.domain.routine.entity.RoutineEntity
import org.example.biblebe.domain.routine.entity.RoutineJpaRepository
import org.example.biblebe.domain.routine.exception.RoutineNotFoundException
import org.example.biblebe.domain.routine.service.GetRoutineService
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class GetRoutineServiceImpl (
    private val routineJpaRepository: RoutineJpaRepository
): GetRoutineService {
    override fun getRoutineById(id: UUID): RoutineEntity {
        return routineJpaRepository.findById(id)
                .orElseThrow { RoutineNotFoundException }
    }

    override fun getRoutinesByUser(user: UserEntity): List<RoutineEntity> {
        return routineJpaRepository.findAllByUser(user)
    }
}