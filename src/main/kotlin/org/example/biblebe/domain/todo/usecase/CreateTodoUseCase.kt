package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.dto.request.CreateTodoRequestDto
import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.service.CommandTodoService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateTodoUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val commandTodoService: CommandTodoService
) {

    fun execute(request: CreateTodoRequestDto) {
        val user = currentUserProvider.getCurrentUser()

        commandTodoService.saveTodo(TodoEntity(
            user = user,
            title = request.title,
            startTime = request.startTime,
            remind = request.remind
        ))
    }
}