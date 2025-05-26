package org.example.biblebe.domain.routine.entity

import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.Optional
import java.util.UUID

interface RoutineHistoryJpaRepository: CrudRepository<RoutineHistoryEntity, UUID> {

    fun findByRoutineAndIsEnd(routine: RoutineEntity, isEnd: Boolean): Optional<RoutineHistoryEntity>

    @Query("""
        SELECT rh
        FROM routine r JOIN routineHistory rh ON (r = rh.routine)
        WHERE r.user = :user
          AND rh.isEnd = true
    """)
    fun findAllEndedRoutineHistoryByUser(@Param("user") user: UserEntity): List<RoutineHistoryEntity>
}