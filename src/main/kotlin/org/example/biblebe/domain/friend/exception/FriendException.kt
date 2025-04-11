package org.example.biblebe.domain.friend.exception

import org.example.biblebe.global.exception.GlobalBusinessException

class FriendException(
    errorCode: FriendErrorCode
) : GlobalBusinessException(errorCode) 