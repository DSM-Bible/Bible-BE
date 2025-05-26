package org.example.biblebe.domain.routine.exception

import org.example.biblebe.global.exception.GlobalBusinessException

object RoutineHistoryNotFoundException: GlobalBusinessException(
    RoutineHistoryErrorCode.ROUTINE_HISTORY_NOT_FOUND
)

object RoutineIsAlreadyEndedException: GlobalBusinessException(
        RoutineHistoryErrorCode.ROUTINE_HAS_ALREADY_END
)