package kfd.homeworks.tasktracker.controller

import jakarta.servlet.http.HttpServletResponse
import kfd.homeworks.tasktracker.model.request.UserRequest
import kfd.homeworks.tasktracker.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val service: UserService
) {
    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}/tasks")
    fun getTasks(@PathVariable("id") id: Long) = service.getTasks(id)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: UserRequest) = service.update(id, request)

    @PostMapping()
    fun create(@RequestBody request: UserRequest) = service.create(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long, response: HttpServletResponse) =
        service.delete(id).also { response.status = 204 }
}