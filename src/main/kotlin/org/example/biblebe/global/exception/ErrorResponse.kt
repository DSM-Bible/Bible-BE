package org.example.biblebe.global.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
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

        fun of(e: BindException): ValidationErrorResponse {
            val errorMap = HashMap<String, String?>()

            for (error: FieldError in e.fieldErrors) {
                errorMap[error.field] = error.defaultMessage
            }

            return ValidationErrorResponse(
                    status = GlobalErrorCode.BAD_REQUEST.getCode(),
                    fieldError = errorMap
            )
        }
    }
}

data class ValidationErrorResponse(
        val status: Int,
        val fieldError: Map<String, String?>
)