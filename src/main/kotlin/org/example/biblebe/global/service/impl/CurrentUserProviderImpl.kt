package org.example.biblebe.global.service.impl

import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.service.GetUserService
import org.example.biblebe.global.security.auth.UserDetailsImpl
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class CurrentUserProviderImpl(
    private val getUserService: GetUserService
): CurrentUserProvider {

    override fun getCurrentUserId(): String {
       return (SecurityContextHolder.getContext().authentication.principal as UserDetailsImpl).username
    }

    override fun getCurrentUser(): UserEntity {
        return getUserService.getUserByUserId(getCurrentUserId())
    }
}