package org.example.biblebe.global

data class ApiResponse<T>(
    val status: String,
    val message: String,
    val data: T
) {
}