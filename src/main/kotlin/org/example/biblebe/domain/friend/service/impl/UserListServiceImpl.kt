package org.example.biblebe.domain.friend.service.impl

import org.example.biblebe.domain.friend.dto.FriendResponse
import org.example.biblebe.domain.friend.dto.UserListResponse
import org.example.biblebe.domain.friend.dto.UserResponse
import org.example.biblebe.domain.friend.repository.FriendRepository
import org.example.biblebe.domain.friend.service.GetFriendService
import org.example.biblebe.domain.friend.service.UserListService
import org.example.biblebe.domain.user.entity.UserJpaRepository
import org.example.biblebe.domain.user.service.GetUserService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserListServiceImpl(
    private val userRepository: UserJpaRepository,
    private val getFriendService: GetFriendService,
    private val currentUserProvider: CurrentUserProvider
) : UserListService {

    @Transactional(readOnly = true)
    override fun getAllUsers(): UserListResponse {
        val currentUser = currentUserProvider.getCurrentUserId()

        val users: List<UserResponse> = userRepository.findAll()
            .filter { getFriendService.selectFriendKeyWord(it.userId).isEmpty()&&!it.userId.equals(currentUser) }
            .map { user ->
                UserResponse(
                    userId = user.userId,
                    userName = user.nickname,
                    imageUrl = user.profile ?: ""
                )
            }

        return UserListResponse(
            user = users
        )
    }
} 