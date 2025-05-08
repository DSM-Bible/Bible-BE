package org.example.biblebe.domain.todo.service.impl

import org.example.biblebe.domain.todo.entity.TodoEntity
import org.example.biblebe.domain.todo.entity.TodoJpaRepository
import org.example.biblebe.domain.todo.exception.TodoNotFoundException
import org.example.biblebe.domain.todo.service.GetTodoService
import org.example.biblebe.domain.user.entity.UserEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetTodoServiceImpl(
    private val todoJpaRepository: TodoJpaRepository
): GetTodoService {

    override fun getTodoByTodoId(id: UUID): TodoEntity {
        return todoJpaRepository.findById(id).orElseThrow {
            TodoNotFoundException
        }
    }

    override fun getTodoList(user: UserEntity): List<TodoEntity> {
        return todoJpaRepository.findAllByUser(user)
    }
}