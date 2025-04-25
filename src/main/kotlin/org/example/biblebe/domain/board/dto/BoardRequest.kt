package org.example.biblebe.domain.board.dto

import jakarta.validation.constraints.NotBlank

data class BoardRequest(
    @field:NotBlank(message = "제목은 필수항목입니다")
    val title: String,
    
    @field:NotBlank(message = "내용은 필수항목입니다")
    val content: String
) 