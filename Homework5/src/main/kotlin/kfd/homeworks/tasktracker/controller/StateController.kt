package kfd.homeworks.tasktracker.controller

import jakarta.servlet.http.HttpServletResponse
import kfd.homeworks.tasktracker.model.request.StateRequest
import kfd.homeworks.tasktracker.service.StateService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/states")
class StateController(
    val service: StateService
) {
    @GetMapping
    fun getAll() = service.getAll()

    @PostMapping
    fun create(@RequestBody request: StateRequest) = service.create(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long, response: HttpServletResponse) =
        service.delete(id).also { response.status = 204 }
}