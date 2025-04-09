package org.example.biblebe.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.biblebe.global.exception.ErrorResponse
import org.example.biblebe.global.exception.GlobalBusinessException
import org.example.biblebe.global.exception.GlobalErrorCode
import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: GlobalBusinessException) {
            e.printStackTrace()
            errorToJson(e.errorProperty, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when(e.cause) {
                is GlobalBusinessException -> {
                    errorToJson((e.cause as GlobalBusinessException).errorProperty, response)
                }
                else -> {
                    errorToJson(GlobalErrorCode.INTERNAL_SERVER_ERROR, response)
                }
            }
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.getCode()
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writer().writeValueAsString(ErrorResponse.of(errorProperty)))
    }
}