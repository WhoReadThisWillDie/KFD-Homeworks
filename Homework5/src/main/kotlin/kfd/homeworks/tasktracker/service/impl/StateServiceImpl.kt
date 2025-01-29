package kfd.homeworks.tasktracker.service.impl

import kfd.homeworks.tasktracker.database.entity.State
import kfd.homeworks.tasktracker.database.repository.StateDao
import kfd.homeworks.tasktracker.model.exception.AlreadyExistsException
import kfd.homeworks.tasktracker.model.exception.NotFoundException
import kfd.homeworks.tasktracker.model.request.StateRequest
import kfd.homeworks.tasktracker.model.response.StateResponse
import kfd.homeworks.tasktracker.service.StateService
import kfd.homeworks.tasktracker.util.StateMapper
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.sql.SQLException

@Service
class StateServiceImpl(
    val dao: StateDao,
    val mapper: StateMapper
) : StateService {
    override fun getById(id: Long): State =
        dao.findById(id).orElseThrow { throw NotFoundException("State with id $id not found") }

    override fun getAll(): List<StateResponse> =
        dao.findAll().map { mapper.entityToResponse(it) }

    override fun create(request: StateRequest): StateResponse {
        val entity = State(name = request.name)
        try {
            return mapper.entityToResponse(dao.save(entity))
        } catch (e: DataIntegrityViolationException) {
            throw AlreadyExistsException("State with name '${request.name}' already exists")
        }
    }

    override fun delete(id: Long) {
        val entity = getById(id)
        dao.delete(entity)
    }
}