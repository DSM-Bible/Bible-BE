package org.example.biblebe.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.biblebe.global.security.jwt.JwtTokenProvider
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig(
        private val objectMapper: ObjectMapper,
        private val jwtTokenProvider: JwtTokenProvider
): SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {
    override fun init(builder: HttpSecurity?) {}

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(objectMapper), JwtFilter::class.java)
    }

}