package org.example.biblebe.domain.routine.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "routine")
@DynamicInsert
@DynamicUpdate
class RoutineEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val routineId: UUID? = null,

    @ManyToOne(optional = true, targetEntity = UserEntity::class)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @Column(columnDefinition = "varchar(12)", nullable = false)
    var name: String,

    @Column(columnDefinition = "datetime", nullable = false)
    var startTime: LocalDateTime,

    @Column(columnDefinition = "datetime", nullable = false)
    var endTime: LocalDateTime,
)