package org.example.biblebe.domain.todo.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.todo.dto.request.CreateTodoRequestDto
import org.example.biblebe.domain.todo.usecase.CreateTodoUseCase
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calender")
class TodoController (
    private val createTodoUseCase: CreateTodoUseCase
) {

    @PostMapping
    fun createTodo(@Valid @RequestBody request: CreateTodoRequestDto) {
        createTodoUseCase.execute(request)
    }
}