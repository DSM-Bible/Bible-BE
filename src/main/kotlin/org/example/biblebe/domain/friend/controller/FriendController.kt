package org.example.biblebe.domain.friend.controller

import org.example.biblebe.domain.friend.dto.AddFriendRequest
import org.example.biblebe.domain.friend.dto.EmptyResponse
import org.example.biblebe.domain.friend.service.FriendAddDeleteService
import org.example.biblebe.domain.friend.service.FriendListService
import org.example.biblebe.global.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friend")
class FriendController(
    private val friendListService: FriendListService,
    private val friendAddDeleteService: FriendAddDeleteService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    fun getFriendList(): ApiResponse<*> {
        val friends = friendListService.getFriendList()
        return ApiResponse(
            status = "200 Ok",
            message = "정상적으로 처리되었습니다",
            data = friends
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun addFriend(@Validated @RequestBody request: AddFriendRequest): ApiResponse<EmptyResponse> {
        friendAddDeleteService.addFriend(request.friendId)
        return ApiResponse(
            status = "200 Ok",
            message = "정상적으로 처리되었습니다",
            data = EmptyResponse()
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/accept")
    fun acceptFriend(@RequestBody request: AddFriendRequest): ApiResponse<*> {
        friendAddDeleteService.setFriendUserTrue(request.friendId)
        return ApiResponse(
            status = "200 Ok",
            message = "정상적으로 처리되었습니다",
            data = EmptyResponse()
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    fun deleteFriend(@Validated @RequestBody request: AddFriendRequest): ApiResponse<EmptyResponse> {
        friendAddDeleteService.deleteFriend(request.friendId)
        return ApiResponse(
            status = "200 Ok",
            message = "정상적으로 처리되었습니다",
            data = EmptyResponse()
        )
    }
} 