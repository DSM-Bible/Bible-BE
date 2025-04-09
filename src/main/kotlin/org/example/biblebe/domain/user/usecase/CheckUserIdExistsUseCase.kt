package org.example.biblebe.domain.user.usecase

import org.example.biblebe.domain.user.dto.request.CheckUserIdExistsRequestDto
import org.example.biblebe.domain.user.dto.response.CheckUserIdExistsResponseDto
import org.example.biblebe.domain.user.service.CheckUserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CheckUserIdExistsUseCase(
    private val checkUserService: CheckUserService
) {
    fun execute(request: CheckUserIdExistsRequestDto): CheckUserIdExistsResponseDto {
        return CheckUserIdExistsResponseDto(checkUserService.checkUserIdExistsResult(request.id))
    }
}