package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.service.CheckTodoService
import org.example.biblebe.domain.todo.service.CommandTodoService
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class DeleteTodoUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getTodoService: GetTodoService,
    private val checkTodoService: CheckTodoService,
    private val commandTodoService: CommandTodoService
) {
    fun execute(todoId: UUID) {
        val user: UserEntity = currentUserProvider.getCurrentUser()
        val todo: TodoEntity = getTodoService.getTodoByTodoId(todoId)

        checkTodoService.checkUserIsOwnerOfTodo(user, todo)

        commandTodoService.deleteTodo(todo)
    }
}