package kfd.homeworks.tasktracker.controller

import kfd.homeworks.tasktracker.model.exception.AlreadyExistsException
import kfd.homeworks.tasktracker.model.response.ExceptionResponse
import kfd.homeworks.tasktracker.model.exception.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionResolver {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity.status(404).body(ExceptionResponse(LocalDateTime.now(), e.message ?: "", 404))
    }

    @ExceptionHandler(AlreadyExistsException::class)
    fun handleAlreadyException(e: AlreadyExistsException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity.status(400).body(ExceptionResponse(LocalDateTime.now(), e.message ?: "", 400))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ExceptionResponse> {
        return ResponseEntity.status(500).body(ExceptionResponse(LocalDateTime.now(), "Something went wrong", 500))
    }
}