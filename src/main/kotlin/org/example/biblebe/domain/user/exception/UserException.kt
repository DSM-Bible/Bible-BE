package org.example.biblebe.domain.user.exception

import org.example.biblebe.global.exception.GlobalBusinessException

class UserException(
    errorCode: UserErrorCode
) : GlobalBusinessException(errorCode) 