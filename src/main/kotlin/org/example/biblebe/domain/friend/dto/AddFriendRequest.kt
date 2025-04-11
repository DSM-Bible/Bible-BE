package org.example.biblebe.domain.friend.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AddFriendRequest(
    @JsonProperty("friend_id")
    val friendId: String
) 