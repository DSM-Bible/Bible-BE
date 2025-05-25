package org.example.biblebe.domain.routine.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.routine.dto.request.CreateRoutineRequestDto
import org.example.biblebe.domain.routine.usecase.CreateRoutineUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/routine")
class RoutineController (
    private val createRoutineUseCase: CreateRoutineUseCase,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createTodo(@Valid @RequestBody request: CreateRoutineRequestDto) {
        createRoutineUseCase.execute(request)
    }
}