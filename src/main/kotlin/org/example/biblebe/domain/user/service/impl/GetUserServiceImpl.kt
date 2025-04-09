package org.example.biblebe.domain.user.service.impl

import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.entity.UserJpaRepository
import org.example.biblebe.domain.user.exception.UserNotFoundException
import org.example.biblebe.domain.user.service.GetUserService
import org.springframework.stereotype.Service

@Service
class GetUserServiceImpl(
   private val userJpaRepository: UserJpaRepository
): GetUserService {

    override fun getUserByUserId(userId: String): UserEntity {
        return userJpaRepository.findById(userId).orElseThrow {
            UserNotFoundException
        }
    }
}