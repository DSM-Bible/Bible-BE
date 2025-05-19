package org.example.biblebe.domain.friend.service.impl

import org.example.biblebe.domain.friend.entity.FriendEntity
import org.example.biblebe.domain.friend.exception.FriendErrorCode
import org.example.biblebe.domain.friend.exception.FriendException
import org.example.biblebe.domain.friend.repository.FriendRepository
import org.example.biblebe.domain.friend.service.FriendAddDeleteService
import org.example.biblebe.domain.user.entity.UserEntity
import org.example.biblebe.domain.user.exception.UserNotFoundException
import org.example.biblebe.domain.user.service.GetUserService
import org.example.biblebe.global.service.CurrentUserProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Isolation
import org.springframework.orm.ObjectOptimisticLockingFailureException
import kotlin.math.log


@Service
class FriendAddDeleteServiceImpl(
    private val friendRepository: FriendRepository,
    private val getUserService: GetUserService,
    private val currentUserProvider: CurrentUserProvider
) : FriendAddDeleteService {

    @Transactional(isolation = Isolation.SERIALIZABLE)
    override fun addFriend(friendId: String) {
        val currentUser = currentUserProvider.getCurrentUser()
        
        if (currentUser.userId == friendId) {
            throw FriendException(FriendErrorCode.CANNOT_ADD_SELF)
        }
        
        val friendUser: UserEntity = getUserService.getUserByUserId(friendId)

        val existingFriend = friendRepository.findByUserAndFriend(currentUser, friendUser)
        if (existingFriend.isPresent) {
            throw FriendException(FriendErrorCode.ALREADY_FRIEND)
        }
        
        val friendEntity = FriendEntity(
            user = currentUser,
            friend = friendUser,
            isAccept = false
        )
        
        friendRepository.save(friendEntity)
    }

    @Transactional
    override fun deleteFriend(friendId: String) {
        val currentUser = currentUserProvider.getCurrentUser()
        val friendUser: UserEntity = getUserService.getUserByUserId(friendId)
        
        // 먼저 user -> friend 방향으로 검색
        val existingFriend = friendRepository.findByUserAndFriend(currentUser, friendUser)
            .orElseGet {
                friendRepository.findByFriendAndUser(currentUser.userId,friendUser.userId).orElseThrow();
            }


        friendRepository.delete(existingFriend)
    }
 
    @Transactional
    override fun setFriendUserTrue(friendId: String) {
        val currentUser = currentUserProvider.getCurrentUser()
        val friendUser: UserEntity = getUserService.getUserByUserId(friendId)

        val existingFriend = friendRepository.findByUserAndFriend(friendUser, currentUser).orElseThrow()
            ?: throw FriendException(FriendErrorCode.FRIEND_NOT_FOUND)

        // 직접 엔티티 속성을 변경하는 대신 쿼리를 사용하여 업데이트
        friendRepository.updateFriendAcceptStatus(existingFriend.id, true)
    }

} 