package org.example.biblebe.domain.routine.controller

import jakarta.validation.Valid
import org.example.biblebe.domain.routine.dto.request.CreateRoutineRequestDto
import org.example.biblebe.domain.routine.dto.request.GetRoutineListRequestDto
import org.example.biblebe.domain.routine.dto.request.UpdateRoutineRequestDto
import org.example.biblebe.domain.routine.dto.response.GetRoutineDetailResponseDto
import org.example.biblebe.domain.routine.dto.response.GetRoutineHistoryListDto
import org.example.biblebe.domain.routine.dto.response.GetRoutineListResponseDto
import org.example.biblebe.domain.routine.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/routine")
class RoutineController (
    private val createRoutineUseCase: CreateRoutineUseCase,
    private val deleteRoutineUseCase: DeleteRoutineUseCase,
    private val updateRoutineUseCase: UpdateRoutineUseCase,
    private val getRoutineListUseCase: GetRoutineListUseCase,
    private val getRoutineDetailUseCase: GetRoutineDetailUseCase,
    private val getRoutineHistoryListUseCase: GetRoutineHistoryListUseCase,
    private val startRoutineUseCase: StartRoutineUseCase,
    private val endRoutineUseCase: EndRoutineUseCase
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
    @PatchMapping("/{routineId}")
    fun updateRoutine(
        @PathVariable routineId: UUID,
        @Valid @RequestBody request: UpdateRoutineRequestDto
    ) {
        updateRoutineUseCase.execute(routineId, request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    fun getRoutineList(
        @Valid @RequestBody request: GetRoutineListRequestDto
    ): GetRoutineListResponseDto {
        return getRoutineListUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/history")
    fun getRoutineHistoryList():GetRoutineHistoryListDto {
        return getRoutineHistoryListUseCase.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{routineId}")
    fun getRoutineDetail(@PathVariable routineId: UUID): GetRoutineDetailResponseDto {
        return getRoutineDetailUseCase.execute(routineId)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/start/{routineId}")
    fun startRoutine(@PathVariable routineId: UUID) {
        startRoutineUseCase.execute(routineId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stop/{routineId}")
    fun endRoutine(@PathVariable routineId: UUID) {
        endRoutineUseCase.execute(routineId)
    }
}