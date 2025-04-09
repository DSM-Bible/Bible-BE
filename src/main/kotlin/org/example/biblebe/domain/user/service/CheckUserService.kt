package org.example.biblebe.domain.user.service

interface CheckUserService {

    fun checkUserIdAlreadyExists(userId: String)

    fun checkUserIdExistsResult(userId: String): Boolean
}