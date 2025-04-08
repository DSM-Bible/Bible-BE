package org.example.biblebe.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

@Configuration
class SecurityConfig {

    @Bean
    fun securityChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/login","/signup", permitAll)
                authorize(anyRequest, authenticated)
            }
        }
        return http.build()
    }
}