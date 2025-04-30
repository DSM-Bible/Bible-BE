package org.example.biblebe.domain.todo.exception

import org.example.biblebe.global.exception.GlobalBusinessException

object NotOwnerOfTodo: GlobalBusinessException(
        TodoErrorCode.NOT_OWNER_OF_TODO
)

object TodoNotFoundException: GlobalBusinessException(
        TodoErrorCode.TODO_NOT_FOUND
)