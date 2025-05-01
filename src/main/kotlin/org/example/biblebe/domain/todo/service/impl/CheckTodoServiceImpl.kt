package org.example.biblebe.domain.todo.service.impl

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.entity.TodoJpaRepository
import org.example.biblebe.domain.todo.exception.NotOwnerOfTodo
import org.example.biblebe.domain.todo.service.CheckTodoService
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.stereotype.Service

@Service
class CheckTodoServiceImpl(
    private val todoJpaRepository: TodoJpaRepository
): CheckTodoService {

    override fun checkUserIsOwnerOfTodo(user: UserEntity, todo: TodoEntity) {
        if (user.userId.equals(todo.user)) {
            throw NotOwnerOfTodo
        }
    }
}