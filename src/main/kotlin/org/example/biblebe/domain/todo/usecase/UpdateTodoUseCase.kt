package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.dto.request.UpdateTodoRequestDto
import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.service.CheckTodoService
import org.example.biblebe.domain.todo.service.CommandTodoService
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class UpdateTodoUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val commandTodoService: CommandTodoService,
    private val checkTodoService: CheckTodoService,
    private val getTodoService: GetTodoService
) {

    fun execute(todoId: UUID, request: UpdateTodoRequestDto) {
        val user: UserEntity = currentUserProvider.getCurrentUser()
        val todo: TodoEntity = getTodoService.getTodoByTodoId(todoId)

        checkTodoService.checkUserIsOwnerOfTodo(user, todo)

        todo.title = request.title!!
        todo.remind = request.remind!!
        todo.startTime = request.startTime!!

        commandTodoService.saveTodo(todo)
    }
}