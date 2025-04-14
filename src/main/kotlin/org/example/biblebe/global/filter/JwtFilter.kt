package org.example.biblebe.global.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.biblebe.global.security.jwt.JwtTokenProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class JwtFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = jwtTokenProvider.resolveToken(request)
        
        if (token != null && jwtTokenProvider.validateToken(token)) {
            val authentication = jwtTokenProvider.getAuthentication(token)
            val details = WebAuthenticationDetailsSource().buildDetails(request)
            val newAuthentication = UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                authentication.authorities
            ).apply {
                this.details = details
            }
            SecurityContextHolder.getContext().authentication = newAuthentication
        }
        
        filterChain.doFilter(request, response)
    }
} 