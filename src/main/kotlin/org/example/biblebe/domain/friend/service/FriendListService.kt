package org.example.biblebe.domain.friend.service

import org.example.biblebe.domain.friend.dto.FriendListResponse

interface FriendListService {
    fun getFriendList(): FriendListResponse
} 