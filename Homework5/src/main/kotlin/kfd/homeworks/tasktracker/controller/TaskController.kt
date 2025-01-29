package kfd.homeworks.tasktracker.controller

import jakarta.servlet.http.HttpServletResponse
import kfd.homeworks.tasktracker.model.request.TaskRequest
import kfd.homeworks.tasktracker.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController(
    val service: TaskService
) {
    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long) = service.getById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: TaskRequest) = service.update(id, request)

    @PostMapping()
    fun create(@RequestBody request: TaskRequest) = service.create(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long, response: HttpServletResponse) =
        service.delete(id).also { response.status = 204 }
}