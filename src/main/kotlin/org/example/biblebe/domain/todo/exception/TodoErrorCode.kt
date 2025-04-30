package org.example.biblebe.domain.todo.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty

enum class TodoErrorCode(
    private val code: Int,
    private val message: String
): ErrorProperty {
    NOT_OWNER_OF_TODO(403, "Todo의 소유자가 아닙니다."),
    TODO_NOT_FOUND(404, "Todo를 찾을 수 없습니다.");

    override fun getCode(): Int {
        return code
    }

    override fun getMessage(): String {
        return message
    }
}