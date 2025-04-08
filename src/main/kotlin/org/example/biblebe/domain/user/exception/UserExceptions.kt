package org.example.biblebe.domain.user.exception

import org.example.biblebe.global.exception.GlobalBusinessException

object UserIdAlreadyExistsException: GlobalBusinessException(
    UserErrorCode.USER_ID_ALREADY_ERROR
)