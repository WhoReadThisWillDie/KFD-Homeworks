package kfd.homeworks.tasktracker.service

import kfd.homeworks.tasktracker.model.request.TaskRequest
import kfd.homeworks.tasktracker.model.response.TaskResponse

interface TaskService {
    fun getAll() : List<TaskResponse>
    fun getById(id: Long) : TaskResponse
    fun update(id: Long, request: TaskRequest) : TaskResponse
    fun create(request: TaskRequest) : TaskResponse
    fun delete(id: Long)
}