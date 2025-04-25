package org.example.biblebe.domain.todo.service

import org.example.biblebe.domain.todo.entity.TodoEntity

interface CommandTodoService {

    fun saveTodo(todoEntity: TodoEntity)
}