package org.example.biblebe.domain.routine.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.routine.dto.request.CreateRoutineRequestDto
import org.example.biblebe.domain.routine.usecase.CreateRoutineUseCase
import org.example.biblebe.domain.routine.usecase.DeleteRoutineUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/routine")
class RoutineController (
    private val createRoutineUseCase: CreateRoutineUseCase,
    private val deleteRoutineUseCase: DeleteRoutineUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createRoutine(@Valid @RequestBody request: CreateRoutineRequestDto) {
        createRoutineUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{routineId}")
    fun deleteRoutine(@PathVariable routineId: UUID) {
        deleteRoutineUseCase.execute(routineId)
    }
}