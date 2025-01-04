package kfd.homeworks.tasktracker.service

import kfd.homeworks.tasktracker.database.entity.State
import kfd.homeworks.tasktracker.model.request.StateRequest
import kfd.homeworks.tasktracker.model.response.DeletedResponse
import kfd.homeworks.tasktracker.model.response.StateResponse

interface StateService {
    fun getById(id: Long) : State
    fun getAll() : List<StateResponse>
    fun create(request: StateRequest) : StateResponse
    fun delete(id: Long) : DeletedResponse
}