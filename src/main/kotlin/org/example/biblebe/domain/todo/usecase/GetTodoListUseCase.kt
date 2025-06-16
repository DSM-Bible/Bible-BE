package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.dto.response.GetTodoListResponseDto
import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class GetTodoListUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getTodoService: GetTodoService
) {
    fun execute(date: LocalDate): GetTodoListResponseDto {
        val todoList = getTodoService.getTodoList(currentUserProvider.getCurrentUser())

        val dateTodoList :List<TodoEntity> = todoList
                .filter { it.startTime.toLocalDate() == date }
                .toList()

        return GetTodoListResponseDto.from(dateTodoList)
    }
}