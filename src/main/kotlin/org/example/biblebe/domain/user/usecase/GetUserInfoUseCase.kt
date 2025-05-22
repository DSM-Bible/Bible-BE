package org.example.biblebe.domain.user.usecase

import org.example.biblebe.domain.user.dto.response.GetUserResponseDto
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = false)
class GetUserInfoUseCase(
     private val currentUserProvider: CurrentUserProvider
) {
    fun execute(): GetUserResponseDto {
        val userEntity: UserEntity = currentUserProvider.getCurrentUser()

        return GetUserResponseDto(userEntity.userId, userEntity.nickname, userEntity.profile!!)
    }
}