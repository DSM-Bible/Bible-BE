package org.example.biblebe.global.service

import org.example.biblebe.domain.user.entity.UserEntity

interface CurrentUserProvider {

    fun getCurrentUserId(): String

    fun getCurrentUser(): UserEntity
}