package org.example.biblebe.global.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import java.time.LocalDateTime

class ErrorResponse(
        val status: Int,
        val message: String,
        val description: String,
        val timestamp: LocalDateTime
) {
    companion object {
        fun of(errorProperty: ErrorProperty): ErrorResponse {
            return ErrorResponse(
                    errorProperty.getCode(),
                    errorProperty.getMessage(),
                    errorProperty.getMessage(),
                    LocalDateTime.now()
            )
        }
    }
}