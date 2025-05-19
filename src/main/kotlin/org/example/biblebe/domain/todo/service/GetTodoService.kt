package org.example.biblebe.domain.todo.service

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.user.entity.UserEntity
import java.util.*

interface GetTodoService {

    fun getTodoByTodoId(id: UUID): TodoEntity

    fun getTodoList(user: UserEntity): List<TodoEntity>
}