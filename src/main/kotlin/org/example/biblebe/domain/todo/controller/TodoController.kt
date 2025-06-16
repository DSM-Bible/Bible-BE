package org.example.biblebe.domain.todo.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.todo.dto.request.CreateTodoRequestDto
import org.example.biblebe.domain.todo.dto.request.UpdateTodoRequestDto
import org.example.biblebe.domain.todo.dto.response.GetTodoListResponseDto
import org.example.biblebe.domain.todo.dto.response.TodoItemDto
import org.example.biblebe.domain.todo.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/calender")
class TodoController(
    private val createTodoUseCase: CreateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val getTodoListUseCase: GetTodoListUseCase,
    private val getTodoDetailUseCase: GetTodoDetailUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createTodo(@Valid @RequestBody request: CreateTodoRequestDto) {
        createTodoUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: UUID) {
        deleteTodoUseCase.execute(todoId)
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: UUID,
        @Valid @RequestBody request: UpdateTodoRequestDto
    ) {
        updateTodoUseCase.execute(todoId, request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    fun getTodoList(): GetTodoListResponseDto {
        return getTodoListUseCase.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{todoId}")
    fun getTodoDetail(
        @PathVariable todoId: UUID
    ): TodoItemDto {
        return getTodoDetailUseCase.execute(todoId)
    }
}