package org.example.biblebe.domain.user.service.impl

import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.entity.UserJpaRepository
import org.example.biblebe.domain.user.service.CommandUserService
import org.springframework.stereotype.Service

@Service
class CommandUserServiceImpl(
    private val userJpaRepository: UserJpaRepository
): CommandUserService {

    override fun saveUser(userEntity: UserEntity) {
        userJpaRepository.save(userEntity)
    }
}