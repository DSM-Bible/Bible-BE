package org.example.biblebe.domain.user.usecase

import org.example.biblebe.domain.user.dto.request.LoginRequestDto
import org.example.biblebe.domain.user.dto.response.LoginResponseDto
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.service.GetUserService
import org.example.biblebe.global.security.JwtTokenProvider
import org.example.biblebe.global.security.SecurityService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LoginUseCase(
    private val getUserService: GetUserService,
    private val securityService: SecurityService,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(request: LoginRequestDto): LoginResponseDto {
        val user: UserEntity = getUserService.getUserByUserId(request.id)

        securityService.checkPasswordMatches(request.password, user.password)

        return LoginResponseDto(jwtTokenProvider.createToken(user.userId))
    }
}