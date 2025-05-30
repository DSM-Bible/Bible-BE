package org.example.biblebe.domain.routine.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.LocalDateTime
import java.util.*

@Entity(name = "routineHistory")
@DynamicInsert
@DynamicUpdate
class RoutineHistoryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val historyId: UUID? = null,

    @ManyToOne(optional = false, targetEntity = RoutineEntity::class)
    @JoinColumn(referencedColumnName = "routineId", name = "routineId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val routine: RoutineEntity,

    @Column(columnDefinition = "datetime", nullable = false)
    var startTime: LocalDateTime,

    @Column(columnDefinition = "datetime", nullable = true)
    var endTime: LocalDateTime? = null,

    @ColumnDefault("0")
    @Column(columnDefinition = "tinyint", nullable = false)
    var isEnd: Boolean? = null
)