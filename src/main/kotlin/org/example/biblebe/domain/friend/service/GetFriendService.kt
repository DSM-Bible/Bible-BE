package org.example.biblebe.domain.friend.service

import org.example.biblebe.domain.friend.dto.FriendResponse

interface GetFriendService {
    fun allFriends() : List<FriendResponse>
}