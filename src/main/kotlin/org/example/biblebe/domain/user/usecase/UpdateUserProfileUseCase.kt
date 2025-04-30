package org.example.biblebe.domain.user.usecase

import org.example.biblebe.domain.user.dto.request.UpdateUserProfileRequestDto
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.service.CommandUserService
import org.example.biblebe.global.service.CurrentUserProvider
import org.example.biblebe.global.thirdparty.s3.FileService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
@Transactional
class UpdateUserProfileUseCase(
    private val commandUserService: CommandUserService,
    private val currentUserProvider: CurrentUserProvider,
    private val fileService: FileService
) {
    fun execute(profile: MultipartFile?, request: UpdateUserProfileRequestDto) {
        val user: UserEntity = currentUserProvider.getCurrentUser()

        user.nickname = request.nickname

        if (profile != null) {
            user.profile = fileService.uploadFile(profile)
        }

        commandUserService.saveUser(user)
    }
}