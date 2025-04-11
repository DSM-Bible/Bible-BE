package org.example.biblebe.domain.friend.service.impl

import org.example.biblebe.domain.friend.entity.FriendEntity
import org.example.biblebe.domain.friend.exception.FriendErrorCode
import org.example.biblebe.domain.friend.exception.FriendException
import org.example.biblebe.domain.friend.repository.FriendRepository
import org.example.biblebe.domain.friend.service.FriendAddDeleteService
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.exception.UserNotFoundException
import org.example.biblebe.domain.user.service.GetUserService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FriendAddDeleteServiceImpl(
    private val friendRepository: FriendRepository,
    private val getUserService: GetUserService
) : FriendAddDeleteService {

    @Transactional
    override fun addFriend(friendId: String) {
        val currentUser = getCurrentUser()
        
        if (currentUser.userId == friendId) {
            throw FriendException(FriendErrorCode.CANNOT_ADD_SELF)
        }
        
        val friendUser: UserEntity = try {
            getUserService.getUserByUserId(friendId)
        } catch (e: Exception) {
            throw UserNotFoundException
        }
        
        val existingFriend = friendRepository.findByUserAndFriend(currentUser, friendUser)
        if (existingFriend != null) {
            throw FriendException(FriendErrorCode.ALREADY_FRIEND)
        }
        
        val friendEntity = FriendEntity(
            user = currentUser,
            friend = friendUser,
            isAccept = true // 바로 수락 상태로 설정
        )
        
        friendRepository.save(friendEntity)
    }

    @Transactional
    override fun deleteFriend(friendId: String) {
        val currentUser = getCurrentUser()
        
        val friendUser: UserEntity = try {
            getUserService.getUserByUserId(friendId)
        } catch (e: Exception) {
            throw UserNotFoundException
        }
        
        val existingFriend = friendRepository.findByUserAndFriend(currentUser, friendUser)
            ?: throw FriendException(FriendErrorCode.FRIEND_NOT_FOUND)
        
        // 친구 관계 삭제
        friendRepository.delete(existingFriend)
    }

    private fun getCurrentUser(): UserEntity {
        val authentication = SecurityContextHolder.getContext().authentication
            ?: throw UserNotFoundException
        
        val userId = authentication.name
        return getUserService.getUserByUserId(userId)
    }
} 