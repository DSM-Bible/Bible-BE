package org.example.biblebe.domain.user.service

import org.example.biblebe.domain.user.entity.UserEntity

interface GetUserService {

    fun getUserByUserId(userId: String): UserEntity
}