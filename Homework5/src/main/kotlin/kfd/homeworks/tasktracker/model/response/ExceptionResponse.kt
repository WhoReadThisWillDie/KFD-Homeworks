package kfd.homeworks.tasktracker.model.response

import java.time.LocalDateTime

data class ExceptionResponse(
    val timestamp: LocalDateTime,
    val message: String,
    val status: Int
)