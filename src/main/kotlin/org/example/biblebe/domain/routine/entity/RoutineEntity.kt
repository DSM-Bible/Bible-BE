package org.example.biblebe.domain.routine.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import org.hibernate.annotations.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity(name = "routine")
@DynamicInsert
@DynamicUpdate
class RoutineEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val routineId: UUID? = null,

    @ManyToOne(optional = false, targetEntity = UserEntity::class)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @Column(columnDefinition = "varchar(12)", nullable = false)
    var name: String,

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    var repeatPeriod: RepeatPeriod,

    @Column(columnDefinition = "time", nullable = false)
    var startTime: LocalTime,

    @Column(columnDefinition = "time", nullable = false)
    var endTime: LocalTime,

    @ColumnDefault("(CURRENT_DATE)")
    @Column(columnDefinition = "date", nullable = false)
    var createdAt: LocalDate? = null
)