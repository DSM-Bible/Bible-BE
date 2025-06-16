package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.dto.response.TodoItemDto
import org.example.biblebe.domain.todo.service.CheckTodoService
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.domain.todo.service.impl.CheckTodoServiceImpl
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class GetTodoDetailUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val checkTodoService: CheckTodoService,
    private val getTodoService: GetTodoService
) {
    fun execute (todoId:UUID): TodoItemDto {
        val user = currentUserProvider.getCurrentUser()
        val todo = getTodoService.getTodoByTodoId(todoId)

        checkTodoService.checkUserIsOwnerOfTodo(user,todo)

        return TodoItemDto.from(todo)
    }
}