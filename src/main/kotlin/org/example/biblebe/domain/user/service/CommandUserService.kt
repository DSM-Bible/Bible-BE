package org.example.biblebe.domain.user.service

import org.example.biblebe.domain.user.entity.UserEntity

interface CommandUserService {

    fun saveUser(userEntity: UserEntity)
}