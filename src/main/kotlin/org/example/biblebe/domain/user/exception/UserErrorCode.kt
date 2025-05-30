package org.example.biblebe.domain.user.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class UserErrorCode(
        private val code: Int,
        private val message: String
): ErrorProperty {

    USER_NOT_FOUND(ErrorStatus.NOT_FOUND, "유저를 찾을 수 없습니다"),
    USER_ID_ALREADY_ERROR(ErrorStatus.CONFLICT, "이미 해당 아이디로 가입된 유저가 존재합니다"),
    AUTHENTICATION_REQUIRED(ErrorStatus.UNAUTHORIZED, "인증이 필요합니다");

    override fun getCode(): Int = code
    override fun getMessage(): String = message
}