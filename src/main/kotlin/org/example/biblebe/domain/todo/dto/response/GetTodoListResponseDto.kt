package org.example.biblebe.domain.todo.dto.response

import org.example.biblebe.domain.todo.entity.TodoEntity
import java.util.UUID

data class GetTodoListResponseDto(
    val data: List<TodoItemDto>
) {
    companion object {
        fun from(todoList: List<TodoEntity>): GetTodoListResponseDto {
            val data = arrayListOf<TodoItemDto>();

            for (todo: TodoEntity in todoList) {
                data.add(TodoItemDto.from(todo))
            }

            return GetTodoListResponseDto(data.toList())
        }
    }
}

data class TodoItemDto(
    val id: UUID,
    val title: String,
    val start_time: String,
    val remind: Int
) {
    companion object {
        fun from(todo: TodoEntity): TodoItemDto {
            return TodoItemDto(
                    todo.todoId!!,
                    todo.title,
                    todo.startTime.toString(),
                    todo.remind
            )
        }
    }
}