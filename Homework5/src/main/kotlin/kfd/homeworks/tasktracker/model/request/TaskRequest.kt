package kfd.homeworks.tasktracker.model.request

data class TaskRequest(
    val title: String,
    val description: String,
    val stateId: Long,
    val userIds: List<Long>
)
