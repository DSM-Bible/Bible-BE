package org.example.biblebe.domain.board.exception

import org.example.biblebe.global.exception.GlobalBusinessException

class BoardException(
    errorCode: BoardErrorCode
) : GlobalBusinessException(errorCode) 