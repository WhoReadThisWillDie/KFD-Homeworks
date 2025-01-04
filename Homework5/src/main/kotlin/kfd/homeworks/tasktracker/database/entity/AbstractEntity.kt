package kfd.homeworks.tasktracker.database.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @GeneratedValue
    val id: Long = 0
) {
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
}