package kfd.homeworks.tasktracker.model.response

import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val title: String,
    val description: String,
    val state: String,
    val users: List<String>
)
