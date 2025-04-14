package org.example.biblebe.domain.friend.service.impl

import org.example.biblebe.domain.friend.dto.FriendResponse
import org.example.biblebe.domain.friend.repository.FriendRepository
import org.example.biblebe.domain.friend.service.GetFriendService
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.exception.UserNotFoundException
import org.example.biblebe.domain.user.service.GetUserService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetFriendServiceImpl(
    private val friendRepository: FriendRepository,
    private val getUserService: GetUserService,
    private val currentUserProvider: CurrentUserProvider
) : GetFriendService {

    @Transactional(readOnly = true)
    override fun allFriends(): List<FriendResponse> {
        val currentUser = currentUserProvider.getCurrentUserId()
        
        return friendRepository.findAllByUserAndIsAcceptTrue(getUserService.getUserByUserId(currentUser))
            .map { 
                FriendResponse(
                    friend_id = it.friend.userId,
                    friend_name = it.friend.nickname,
                    image_url = it.friend.profile ?: ""
                )
            }
    }

} 