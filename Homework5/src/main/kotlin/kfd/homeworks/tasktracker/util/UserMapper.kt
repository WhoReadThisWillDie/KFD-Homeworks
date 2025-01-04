package kfd.homeworks.tasktracker.util

import kfd.homeworks.tasktracker.database.entity.User
import kfd.homeworks.tasktracker.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun entityToResponse(entity: User): UserResponse =
        UserResponse(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name
        )
}