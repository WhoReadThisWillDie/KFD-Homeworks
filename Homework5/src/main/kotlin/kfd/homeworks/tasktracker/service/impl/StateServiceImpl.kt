package kfd.homeworks.tasktracker.service.impl

import kfd.homeworks.tasktracker.database.entity.State
import kfd.homeworks.tasktracker.database.repository.StateDao
import kfd.homeworks.tasktracker.model.request.StateRequest
import kfd.homeworks.tasktracker.model.response.DeletedResponse
import kfd.homeworks.tasktracker.model.response.StateResponse
import kfd.homeworks.tasktracker.service.StateService
import kfd.homeworks.tasktracker.util.StateMapper
import org.springframework.stereotype.Service

@Service
class StateServiceImpl(
    val dao: StateDao,
    val mapper: StateMapper
) : StateService {
    override fun getById(id: Long): State =
        dao.findById(id).orElseThrow { throw RuntimeException("") }

    override fun getAll(): List<StateResponse> =
        dao.findAll().map { mapper.entityToResponse(it) }

    override fun create(request: StateRequest): StateResponse {
        val entity = State(name = request.name)
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun delete(id: Long): DeletedResponse {
        val entity = getById(id)
        dao.delete(entity)
        return DeletedResponse()
    }
}