package org.example.biblebe.domain.todo.exception

import org.example.biblebe.global.exception.GlobalErrorCode
import org.example.biblebe.global.exception.errorCode.ErrorProperty

enum class TodoErrorCode(
    private val code: Int,
    private val message: String
): ErrorProperty {}