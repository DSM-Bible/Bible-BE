package org.example.biblebe.domain.friend.service.impl

import org.example.biblebe.domain.friend.dto.FriendListResponse
import org.example.biblebe.domain.friend.service.FriendListService
import org.example.biblebe.domain.friend.service.GetFriendService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FriendListServiceImpl(
    private val getFriendService: GetFriendService
) : FriendListService {

    @Transactional(readOnly = true)
    override fun getFriendList(): FriendListResponse {
        val friends = getFriendService.allFriends()
        return FriendListResponse(friend = friends)
    }
} 