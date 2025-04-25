package org.example.biblebe.domain.todo.service.impl

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.entity.TodoJpaRepository
import org.example.biblebe.domain.todo.service.CommandTodoService
import org.springframework.stereotype.Service

@Service
class CommandTodoServiceImpl(
    private val todoJpaRepository: TodoJpaRepository
): CommandTodoService {

    override fun saveTodo(todoEntity: TodoEntity) {
        todoJpaRepository.save(todoEntity)
    }
}