package org.example.biblebe.domain.routine.entity

import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate
import java.util.*

interface RoutineJpaRepository: CrudRepository<RoutineEntity, UUID> {

    fun findAllByNextRoutineDateAndUser(nextRoutineDate: LocalDate, user: UserEntity): List<RoutineEntity>
}