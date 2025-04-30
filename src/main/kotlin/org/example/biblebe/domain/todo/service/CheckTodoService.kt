package org.example.biblebe.domain.todo.service

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.user.entity.UserEntity

interface CheckTodoService {

    fun checkUserIsOwnerOfTodo(user: UserEntity, todo: TodoEntity)
}