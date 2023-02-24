package com.ken1427.bulletinboardapi.kt.controller

import com.ken1427.bulletinboardapi.kt.service.user.UserRequest
import com.ken1427.bulletinboardapi.kt.service.user.UserResponse
import com.ken1427.bulletinboardapi.kt.service.user.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Null

@RestController
@RequestMapping("/v1")
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/users")
    @Operation(summary = "Get all active users information.")
    fun getAllActiveUsers(): ResponseEntity<List<UserResponse>> {
        val result = userService.getActiveUsers()

        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping(path = ["/users"], headers = ["Content-Type=application/json"])
    @Operation(summary = "Create a user.")
    fun createUser(
        @RequestBody(required = true)
        @Parameter(description = "A user information", example = """{"username": "Bob", "mail_address": "xyz@example.com"}""")
        body: UserRequest
    ): ResponseEntity<UserResponse> {
        val result = userService.create(body)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("/users/{userId}")
    @Operation(summary = "Get user information.")
    fun getUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): ResponseEntity<UserResponse> {
        val result = userService.get(userId.toInt())

        return ResponseEntity(result, HttpStatus.OK)
    }

    @PutMapping(path = ["/users/{userId}"], headers = ["Content-Type=application/json"])
    @Operation(summary = "Update user information.")
    fun updateUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String,
        @RequestBody(required = true)
        @Parameter(description = "A user information", example = "{username: Bob, mail_address: xyz@example.com}")
        body: UserRequest
    ): ResponseEntity<UserResponse> {
        val result = userService.update(userId.toInt(), body)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @DeleteMapping("/users/{userId}")
    @Operation(summary = "Delete a user.")
    fun deleteUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): ResponseEntity<Null> {
        userService.delete(userId.toInt())

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/users/{userId}/status")
    @Operation(summary = "Update user status.")
    fun updateUserStatus(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String,
        @RequestParam(value = "action", defaultValue = "activate", required = false)
        @Parameter(description = "activate or inactivate user status", example = "activate/inactivate")
        action: String
    ): ResponseEntity<Null> {
        userService.updateStatus(userId.toInt(), action)

        return ResponseEntity(HttpStatus.OK)
    }
}