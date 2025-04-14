package org.example.biblebe.global.security.exception

import org.example.biblebe.global.exception.GlobalBusinessException

object PasswordMismatchesException: GlobalBusinessException(
        SecurityErrorCode.PASSWORD_MISMATCHES
)

object TokenNotValidException: GlobalBusinessException(
        SecurityErrorCode.TOKEN_NOT_VALID
)