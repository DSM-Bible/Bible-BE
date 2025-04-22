package org.example.biblebe.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfig = CorsConfiguration()

        corsConfig.allowedOriginPatterns = listOf("http://localhost:*", "http://127.0.0.1:*")
        corsConfig.allowedMethods = listOf("GET", "POST", "PUT", "PATCH", "DELETE")
        corsConfig.allowedHeaders = listOf("Authorization", "Content-Type")
        corsConfig.exposedHeaders = listOf("Custom-Header")
        corsConfig.allowCredentials = true
        corsConfig.maxAge = 3600

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)

        return source
    }
}