package org.example.biblebe.global.config

import org.example.biblebe.global.filter.FilterConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig(
    private val filterConfig: FilterConfig
) {

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            cors { Customizer.withDefaults<Any>() }
            httpBasic { disable() }
            formLogin { disable() }

            authorizeHttpRequests {
                // account
                authorize(HttpMethod.POST, "/account/login", permitAll)
                authorize(HttpMethod.POST, "/account/signup", permitAll)
                authorize(HttpMethod.GET, "/account/userId", permitAll)
                authorize(HttpMethod.GET, "/account", authenticated)
                authorize(HttpMethod.PATCH, "/account", authenticated)

                // calender
                authorize(HttpMethod.POST, "/calender", authenticated)
                authorize(HttpMethod.PATCH, "/calender/{todoId}", authenticated)
                authorize(HttpMethod.DELETE, "/calender/{todoId}", authenticated)
                authorize(HttpMethod.GET, "/calender/list", authenticated)
                authorize(HttpMethod.GET, "/calender/detail", authenticated)

                // routine
                authorize(HttpMethod.POST, "/routine", authenticated)
                authorize(HttpMethod.DELETE, "/routine/{routineId}", authenticated)
                authorize(HttpMethod.PATCH, "/routine/{routineId}", authenticated)
                authorize(HttpMethod.GET, "/routine/list", authenticated)
                authorize(HttpMethod.GET, "/routine/detail/{routineId}", authenticated)
                authorize(HttpMethod.POST, "/routine/start/{routineId}", authenticated)
                authorize(HttpMethod.PATCH, "/routine/stop/{routineId}", authenticated)

                // board
                authorize(HttpMethod.POST, "/board", authenticated)
                authorize(HttpMethod.POST, "/board/**", authenticated)
                authorize(HttpMethod.PATCH, "/board", authenticated)
                authorize(HttpMethod.DELETE, "/board/**", authenticated)
                authorize(HttpMethod.GET, "/board/list", authenticated)
                authorize(HttpMethod.GET, "/board/**", authenticated)
                authorize(HttpMethod.GET, "/board/:id", authenticated)

                // friend
                authorize(HttpMethod.POST, "/friend", authenticated)
                authorize(HttpMethod.DELETE, "/friend", authenticated)
                authorize(HttpMethod.GET, "/friend/list", authenticated)
                authorize(HttpMethod.GET, "/friend/*", authenticated)
                authorize(HttpMethod.PATCH, "/friend/acceptance", authenticated)

                authorize(anyRequest,denyAll)
            }

            sessionManagement { SessionCreationPolicy.STATELESS }
            headers { frameOptions { sameOrigin } }
        }
        http.apply(filterConfig)

        return http.build()
    }
}