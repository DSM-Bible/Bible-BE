package org.example.biblebe.global.security.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class SecurityErrorCode(
   private val code: Int,
   private val message: String
): ErrorProperty {
    PASSWORD_MISMATCHES(ErrorStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다");

    override fun getCode(): Int = code
    override fun getMessage(): String = message
}