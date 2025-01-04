package kfd.homeworks.tasktracker.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "state")
class State(
    @Column(nullable = false, unique = true)
    val name: String
) : AbstractEntity() {
}