package org.example.biblebe.domain.routine.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class RoutineHistoryErrorCode(
    private val code: Int,
    private val message: String
): ErrorProperty {
    ROUTINE_HISTORY_NOT_FOUND(ErrorStatus.NOT_FOUND, "루틴 기록을 찾을 수 없습니다."),
    ROUTINE_HAS_ALREADY_END(ErrorStatus.CONFLICT, "이미 종료된 루틴에 대하여 종료를 시도했습니다.");

    override fun getCode(): Int {
        return code
    }

    override fun getMessage(): String {
        return message
    }
}