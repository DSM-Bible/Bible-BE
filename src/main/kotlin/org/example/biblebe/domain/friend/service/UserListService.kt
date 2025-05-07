package org.example.biblebe.domain.friend.service

import org.example.biblebe.domain.friend.dto.UserListResponse
import org.example.biblebe.domain.friend.dto.UserResponse

interface UserListService {
    fun getAllUsers(): UserListResponse
} 