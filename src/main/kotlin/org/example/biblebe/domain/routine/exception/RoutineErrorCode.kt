package org.example.biblebe.domain.routine.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class RoutineErrorCode(
    private val code: Int,
    private val message: String
) : ErrorProperty {
    ROUTINE_NOT_FOUND(ErrorStatus.NOT_FOUND, "루틴을 찾을 수 없습니다.");

    override fun getCode(): Int = code
    override fun getMessage(): String = message
} 