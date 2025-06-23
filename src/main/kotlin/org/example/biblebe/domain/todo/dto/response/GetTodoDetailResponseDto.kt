package org.example.biblebe.domain.todo.dto.response

import java.time.LocalDateTime

data class GetTodoDetailResponseDto(
        val title: String,
        var startTime: LocalDateTime,
        var remind: Int,
) {}