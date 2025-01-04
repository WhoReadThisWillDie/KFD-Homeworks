package kfd.homeworks.tasktracker.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "task")
class Task(
    @Column(nullable = false)
    var title: String,
    @Column(nullable = false)
    @Lob
    var description: String
) : AbstractEntity() {
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    var state: State? = null

    @ManyToMany(targetEntity = User::class)
    @JoinTable(
        name = "task_to_user",
        joinColumns = [JoinColumn(name = "task_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var users: List<User> = listOf()
}