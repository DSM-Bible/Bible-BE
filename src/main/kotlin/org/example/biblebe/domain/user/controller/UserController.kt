package org.example.biblebe.domain.user.controller

import org.example.biblebe.domain.user.dto.request.CheckUserIdExistsRequestDto
import org.example.biblebe.domain.user.dto.request.LoginRequestDto
import org.example.biblebe.domain.user.dto.request.SignupRequestDto
import org.example.biblebe.domain.user.dto.request.UpdateUserProfileRequestDto
import org.example.biblebe.domain.user.dto.response.CheckUserIdExistsResponseDto
import org.example.biblebe.domain.user.dto.response.GetUserResponseDto
import org.example.biblebe.domain.user.dto.response.LoginResponseDto
import org.example.biblebe.domain.user.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/account")
class UserController(
    private val signupUseCase: SignupUseCase,
    private val loginUseCase: LoginUseCase,
    private val checkUserIdExistsUseCase: CheckUserIdExistsUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase,
    private val userInfoUseCase: GetUserInfoUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun createUser(
        @RequestPart("file", required = false) file: MultipartFile?,
        @Validated @RequestPart("body") request: SignupRequestDto
    ) {
        signupUseCase.execute(file, request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    fun login(@Validated @RequestBody request: LoginRequestDto): LoginResponseDto {
        return loginUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/userId")
    fun checkUserIdExists(@Validated @RequestBody request: CheckUserIdExistsRequestDto): CheckUserIdExistsResponseDto {
        return checkUserIdExistsUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getCurrentUserInfo(): GetUserResponseDto {
        return userInfoUseCase.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    fun updateUser(
        @RequestPart("file", required = false) file: MultipartFile?,
        @Validated @RequestPart("body") request: UpdateUserProfileRequestDto
    ) {
        return updateUserProfileUseCase.execute(file, request)
    }
}