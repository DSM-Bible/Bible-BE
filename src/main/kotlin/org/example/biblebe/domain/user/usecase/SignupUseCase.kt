package org.example.biblebe.domain.user.usecase

import jakarta.transaction.Transactional
import org.example.biblebe.domain.user.dto.request.SignupRequestDto
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.service.CheckUserService
import org.example.biblebe.domain.user.service.CommandUserService
import org.example.biblebe.global.security.SecurityService
import org.example.biblebe.global.thirdparty.s3.FileService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
@Transactional
class SignupUseCase(
    private val checkUserService: CheckUserService,
    private val commandUserService: CommandUserService,
    private val securityService: SecurityService,
    private val fileService: FileService
) {
    fun execute(file: MultipartFile?, request: SignupRequestDto) {
        checkUserService.checkUserIdAlreadyExists(request.id)

        val encryptedPassword = securityService.encodePassword(request.password)

        var profileUrl: String? = null
        if (file != null) {
            profileUrl = fileService.uploadFile(file)
        }

        commandUserService.saveUser(UserEntity(
                request.id,
                encryptedPassword,
                request.nickname,
                profileUrl
        ))
    }
}