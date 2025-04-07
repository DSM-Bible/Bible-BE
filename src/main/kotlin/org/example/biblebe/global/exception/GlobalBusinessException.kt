package org.example.biblebe.global.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty

abstract class GlobalBusinessException (
        val errorProperty: ErrorProperty
): RuntimeException()