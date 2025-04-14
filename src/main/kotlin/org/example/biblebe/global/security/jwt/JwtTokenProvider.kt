package org.example.biblebe.global.security.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.example.biblebe.global.security.auth.UserDetailsImpl
import org.example.biblebe.global.security.exception.TokenNotValidException
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*

@Component
class JwtTokenProvider(
    @Value("\${jwt.secret}")
    private val secretKey: String,
    @Value("\${jwt.expiration}")
    private val expiration: Long
) {
    private val key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))

    fun createToken(userId: String): String {
        val now = Date()
        val expiryDate = Date(now.time + expiration)

        return Jwts.builder()
            .setSubject(userId)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key)
            .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaim(token)
        val principal = UserDetailsImpl(claims.subject)

        return UsernamePasswordAuthenticationToken(principal, "", principal.authorities)
    }

    fun getClaim(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .body
        } catch (e: Exception) {
            throw TokenNotValidException
        }
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            true
        } catch (e: JwtException) {
            false
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }
} 