package org.example.biblebe.domain.todo.usecase


import org.example.biblebe.domain.todo.dto.response.GetTodoDetailResponseDto
import org.example.biblebe.domain.todo.service.GetTodoService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(readOnly = true)
class GetTodoDetailUseCase(
    private val getTodoService: GetTodoService
) {
    fun execute(todoId: UUID): GetTodoDetailResponseDto {
        val todo = getTodoService.getTodoByTodoId(todoId)

        return GetTodoDetailResponseDto(todo.title, todo.startTime, todo.remind)
    }
}