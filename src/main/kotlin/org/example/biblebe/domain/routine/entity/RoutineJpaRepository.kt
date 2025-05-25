package org.example.biblebe.domain.routine.entity

import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.*

interface RoutineJpaRepository: CrudRepository<RoutineEntity, UUID> {

    @Query("""
        SELECT * 
        FROM routine r
        WHERE DATE(r.startTime) = :today
            AND r.user_id = :user_id
    """, nativeQuery = true)
    fun findAllTodayRoutine(
            @Param("start") today: LocalDate,
            @Param("user") userId: String
    ): List<RoutineEntity>
}