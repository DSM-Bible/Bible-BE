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
        val user = getUserService.getUserByUserId(currentUser)

        return friendRepository.findAllByUser(user)
            .filter { it.isAccept }
            .map { 
                FriendResponse(
                    friend_id = it.friend.userId,
                    friend_name = it.friend.nickname,
                    image_url = it.friend.profile ?: "",
                    is_accepted = it.isAccept
                )
            } + friendRepository.findAllByFriend(user)
            .map {
                FriendResponse(
                    friend_id = it.user.userId,
                    friend_name = it.user.nickname,
                    image_url = it.user.profile ?: "",
                    is_accepted = it.isAccept
                )
            }
    }

    override fun selectFriendKeyWord(keyWord: String): List<FriendResponse> {
        val currentUser = currentUserProvider.getCurrentUserId()
        return friendRepository.getFriendByKeyWord(currentUser, keyWord)
            ?.map {
               if (it.friend.userId.equals(currentUser)){
                   FriendResponse(
                       friend_id = it.user.userId,
                       friend_name = it.user.nickname,
                       image_url = it.user.profile ?: "",
                       is_accepted = it.isAccept
                   )
               } else{
                   FriendResponse(
                       friend_id = it.friend.userId,
                       friend_name = it.friend.nickname,
                       image_url = it.friend.profile ?: "",
                       is_accepted = it.isAccept
                   )
               }

            } ?: emptyList()
    }

} 