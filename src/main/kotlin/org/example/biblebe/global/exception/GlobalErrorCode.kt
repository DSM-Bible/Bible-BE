package org.example.biblebe.global.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class GlobalErrorCode(
        private val code: Int,
        private val message: String
) : ErrorProperty {

    BAD_REQUEST(ErrorStatus.BAD_REQUEST, "잘못된 요청입니다"),

    INTERNAL_SERVER_ERROR(ErrorStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다");

    override fun getCode(): Int = code;
    override fun getMessage(): String = message
}