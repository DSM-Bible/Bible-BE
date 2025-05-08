package org.example.biblebe.domain.todo.usecase

import org.example.biblebe.domain.todo.dto.response.GetTodoListResponseDto
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class GetTodoListUseCase(
    private val currentUserProvider: CurrentUserProvider,
    private val getTodoService: GetTodoService
) {
    fun execute(): GetTodoListResponseDto {
        return GetTodoListResponseDto.from(getTodoService.getTodoList(
                currentUserProvider.getCurrentUser()
        ))
    }
}