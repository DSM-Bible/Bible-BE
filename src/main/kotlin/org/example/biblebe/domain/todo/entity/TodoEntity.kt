package org.example.biblebe.domain.todo.entity

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

@Entity(name = "todo")
@DynamicInsert
@DynamicUpdate
class TodoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val todoId: UUID? = null,

    @ManyToOne(optional = true, targetEntity = UserEntity::class)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @Column(columnDefinition = "varchar(200)", nullable = false)
    var title: String,

    @Column(columnDefinition = "datetime", nullable = true)
    var startTime: LocalDateTime,


    @ColumnDefault("'0'")
    @Column(columnDefinition = "integer", nullable = false)
    var remind: Int,

    @ColumnDefault("'0'")
    @Column(columnDefinition = "tinyint", nullable = false)
    var isCompleted: Boolean? = null
)