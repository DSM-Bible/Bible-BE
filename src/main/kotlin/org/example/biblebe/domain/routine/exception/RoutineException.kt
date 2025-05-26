package org.example.biblebe.domain.routine.exception

import org.example.biblebe.global.exception.GlobalBusinessException

object RoutineNotFoundException: GlobalBusinessException(
        RoutineErrorCode.ROUTINE_NOT_FOUND
)

object NotOwnerOfRoutineException: GlobalBusinessException(
        RoutineErrorCode.NOT_OWNER_OF_ROUTINE
)