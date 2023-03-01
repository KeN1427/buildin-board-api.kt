package com.ken1427.bulletinboardapi.kt.controller

import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest
import com.ken1427.bulletinboardapi.kt.usecase.user.UserResponse
import com.ken1427.bulletinboardapi.kt.usecase.user.CreateUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.DeleteUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.GetActiveUsersUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.GetUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.RestoreUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.UpdateUserUseCase
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
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Null

@RestController
@RequestMapping("/v1")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val getActiveUsersUseCase: GetActiveUsersUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val restoreUserUseCase: RestoreUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
) {
    @GetMapping("/users")
    @Operation(summary = "Get all active users information.")
    fun getAllActiveUsers(): ResponseEntity<List<UserResponse>> {
        val result = getActiveUsersUseCase.handle()

        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping("/users", headers = ["Content-Type=application/json"])
    @Operation(summary = "Create a user.")
    fun createUser(
        @RequestBody(required = true)
        @Parameter(description = "A user information", example = """{"username": "Bob", "mail_address": "xyz@example.com"}""")
        userRequest: UserRequest
    ): ResponseEntity<UserResponse> {
        val result = createUserUseCase.handle(userRequest)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("/users/{userId}")
    @Operation(summary = "Get user information.")
    fun getUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): ResponseEntity<UserResponse> {
        val result = getUserUseCase.handle(userId.toInt())

        return ResponseEntity(result, HttpStatus.OK)
    }

    @PutMapping("/users/{userId}", headers = ["Content-Type=application/json"])
    @Operation(summary = "Update user information.")
    fun updateUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String,
        @RequestBody(required = true)
        @Parameter(
            description = "A user information",
            example = """{username: "Bob", mail_address: "xyz@example.com"}"""
        )
        userRequest: UserRequest
    ): ResponseEntity<UserResponse> {
        val result = updateUserUseCase.handle(userId.toInt(), userRequest)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @DeleteMapping("/users/{userId}")
    @Operation(summary = "Delete a user.")
    fun deleteUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): ResponseEntity<Null> {
        deleteUserUseCase.handle(userId.toInt())

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PostMapping("/users/{userId}", headers = ["Content-Type=application/json"])
    @Operation(summary = "Restore a user.")
    fun updateUserStatus(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String,
    ): ResponseEntity<Null> {
        restoreUserUseCase.handle(userId.toInt())

        return ResponseEntity(HttpStatus.OK)
    }
}