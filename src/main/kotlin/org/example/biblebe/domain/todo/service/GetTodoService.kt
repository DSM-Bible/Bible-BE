package org.example.biblebe.domain.todo.service

import org.example.biblebe.domain.todo.entity.TodoEntity
import java.util.*

interface GetTodoService {

    fun getTodoByTodoId(id: UUID): TodoEntity
}