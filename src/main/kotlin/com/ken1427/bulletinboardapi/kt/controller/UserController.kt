package com.ken1427.bulletinboardapi.kt.controller

import com.ken1427.bulletinboardapi.kt.usecase.user.CreateUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {
    @PostMapping(path = ["/users"], headers = ["Content-Type=application/json"])
    @Operation(summary = "Create a user.")
    fun createUser(
        @RequestBody(required = true)
        @Parameter(description = "A user information", example = "{username: Bob, mail_address: xyz@example.com}")
        body: UserRequest
    ): String {
        createUserUseCase.handle(body)
        return "${body.username}"
    }

    @GetMapping("/users/{userId}")
    @Operation(summary = "Get user information.")
    fun getUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): String {
        return "Get user information."
    }

    @PutMapping("/users/{userId}")
    @Operation(summary = "Update user information.")
    fun updateUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): String {
        return "Update user information."
    }

    @DeleteMapping("/users/{userId}")
    @Operation(summary = "Delete a user.")
    fun deleteUser(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): String {
        return "Delete a user."
    }
}