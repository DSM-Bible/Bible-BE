package org.example.biblebe.domain.todo.entity

import jakarta.persistence.*
import org.example.biblebe.domain.user.entity.UserEntity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.LocalDate
import java.util.UUID

@Entity(name = "todo")
@DynamicInsert
class TodoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val todoId: UUID? = null,

    @ManyToOne(optional = true, targetEntity = UserEntity::class)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private val user: UserEntity,

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private val title: String,

    @Column(columnDefinition = "datetime", nullable = true)
    private val startTime: LocalDate,


    @ColumnDefault("'0'")
    @Column(columnDefinition = "integer", nullable = false)
    private val remind: Int,

    @ColumnDefault("'0'")
    @Column(columnDefinition = "tinyint", nullable = false)
    private val isCompleted: Boolean? = null
)