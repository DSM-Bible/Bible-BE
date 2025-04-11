package org.example.biblebe.domain.friend.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class FriendErrorCode(
    private val code: Int,
    private val message: String
) : ErrorProperty {
    ALREADY_FRIEND(ErrorStatus.CONFLICT, "이미 등록된 친구입니다"),
    FRIEND_NOT_FOUND(ErrorStatus.NOT_FOUND, "친구 관계를 찾을 수 없습니다"),
    CANNOT_ADD_SELF(ErrorStatus.BAD_REQUEST, "자기 자신을 친구로 추가할 수 없습니다");

    override fun getCode(): Int = code
    override fun getMessage(): String = message
} 