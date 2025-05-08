package org.example.biblebe.domain.todo.entity

import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TodoJpaRepository: CrudRepository<TodoEntity, UUID> {

    fun findAllByUser(user: UserEntity): List<TodoEntity>
}