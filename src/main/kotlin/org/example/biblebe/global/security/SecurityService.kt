package org.example.biblebe.global.security

import org.example.biblebe.global.security.exception.PasswordMismatchesException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class SecurityService(
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun encodePassword(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }

    fun checkPasswordMatches(rawPassword: String, encryptedPassword: String) {
        if (!passwordEncoder.matches(rawPassword, encryptedPassword)) {
            throw PasswordMismatchesException
        }
    }
}