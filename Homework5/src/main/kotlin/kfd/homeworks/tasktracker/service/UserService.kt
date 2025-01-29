package kfd.homeworks.tasktracker.service

import kfd.homeworks.tasktracker.database.entity.User
import kfd.homeworks.tasktracker.model.request.UserRequest
import kfd.homeworks.tasktracker.model.response.TaskResponse
import kfd.homeworks.tasktracker.model.response.UserResponse

interface UserService {
    fun getById(id: Long) : User
    fun getAll() : List<UserResponse>
    fun getTasks(id: Long) : List<TaskResponse>
    fun update(id: Long, request: UserRequest) : UserResponse
    fun create(request: UserRequest) : UserResponse
    fun delete(id: Long)
}