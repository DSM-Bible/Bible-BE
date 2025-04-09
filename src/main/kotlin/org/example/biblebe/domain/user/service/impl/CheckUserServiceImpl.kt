package org.example.biblebe.domain.user.service.impl

import org.example.biblebe.domain.user.entity.UserJpaRepository
import org.example.biblebe.domain.user.exception.UserIdAlreadyExistsException
import org.example.biblebe.domain.user.service.CheckUserService
import org.springframework.stereotype.Service

@Service
class CheckUserServiceImpl(
    private val userJpaRepository: UserJpaRepository
): CheckUserService {

    override fun checkUserIdAlreadyExists(userId: String) {
        if (userJpaRepository.existsById(userId)) {
            throw UserIdAlreadyExistsException
        }
    }

    override fun checkUserIdExistsResult(userId: String): Boolean {
        return  userJpaRepository.existsById(userId)
    }
}