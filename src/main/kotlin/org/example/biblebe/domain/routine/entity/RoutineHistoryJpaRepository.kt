package org.example.biblebe.domain.routine.entity

import org.springframework.data.repository.CrudRepository
import java.util.Optional
import java.util.UUID

interface RoutineHistoryJpaRepository: CrudRepository<RoutineHistoryEntity, UUID> {

    fun findByRoutineAndIsEnd(routine: RoutineEntity, isEnd: Boolean): Optional<RoutineHistoryEntity>
}