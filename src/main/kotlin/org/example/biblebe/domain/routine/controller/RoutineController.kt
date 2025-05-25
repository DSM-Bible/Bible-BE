package org.example.biblebe.domain.routine.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.routine.dto.request.CreateRoutineRequestDto
import org.example.biblebe.domain.routine.dto.response.GetRoutineListResponseDto
import org.example.biblebe.domain.routine.usecase.CreateRoutineUseCase
import org.example.biblebe.domain.routine.usecase.DeleteRoutineUseCase
import org.example.biblebe.domain.routine.usecase.GetRoutineListUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/routine")
class RoutineController (
    private val createRoutineUseCase: CreateRoutineUseCase,
    private val deleteRoutineUseCase: DeleteRoutineUseCase,
    private val getRoutineListUseCase: GetRoutineListUseCase
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

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/list")
    fun getRoutineList(): List<GetRoutineListResponseDto> {
        return getRoutineListUseCase.execute()
    }
}