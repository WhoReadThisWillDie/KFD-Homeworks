package kfd.homeworks.tasktracker.util

import kfd.homeworks.tasktracker.database.entity.State
import kfd.homeworks.tasktracker.model.response.StateResponse
import org.springframework.stereotype.Component

@Component
class StateMapper {
    fun entityToResponse(entity: State): StateResponse =
        StateResponse(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name
        )
}