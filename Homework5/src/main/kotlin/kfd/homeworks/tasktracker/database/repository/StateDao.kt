package kfd.homeworks.tasktracker.database.repository

import kfd.homeworks.tasktracker.database.entity.State
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StateDao : CrudRepository<State, Long>