package org.example.biblebe.global.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class SecurityService(
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun encodePassword(rawPassword: String) = passwordEncoder.encode(rawPassword)
}