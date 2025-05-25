package org.example.biblebe.domain.routine.entity

import org.springframework.data.repository.CrudRepository
import java.util.*

interface RoutineJpaRepository: CrudRepository<RoutineEntity, UUID> {
}