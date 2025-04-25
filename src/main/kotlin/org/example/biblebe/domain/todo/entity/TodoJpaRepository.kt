package org.example.biblebe.domain.todo.entity

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TodoJpaRepository: CrudRepository<TodoEntity, UUID> {
}