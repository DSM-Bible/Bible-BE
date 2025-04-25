package org.example.biblebe.domain.board.exception

import org.example.biblebe.global.exception.errorCode.ErrorProperty
import org.example.biblebe.global.exception.errorCode.ErrorStatus

enum class BoardErrorCode(
    private val code: Int,
    private val message: String
) : ErrorProperty {
    BOARD_NOT_FOUND(ErrorStatus.NOT_FOUND, "게시글을 찾을 수 없습니다"),
    NOT_BOARD_OWNER(ErrorStatus.FORBIDDEN, "게시글의 작성자가 아닙니다"),
    FILE_UPLOAD_ERROR(ErrorStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다"),
    FILE_NOT_FOUND(ErrorStatus.NOT_FOUND, "파일을 찾을 수 없습니다");

    override fun getCode(): Int = code
    override fun getMessage(): String = message
} 