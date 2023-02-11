package com.ken1427.buildinboardapi.kt

import com.ken1427.buildinboardapi.kt.request.UserRequest
import com.ken1427.buildinboardapi.kt.response.HealthCheckResponse
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

@RestController
@RequestMapping("/v1")
class ApiController {
    @GetMapping(path = ["/"])
    @Operation(summary = "Health check")
    fun healthCheck(
        @RequestParam(value = "name", defaultValue = "world", required = false)
        @Parameter(description = "Your name", example = "Bob")
        name: String
    ): ResponseEntity<HealthCheckResponse> {
        return ResponseEntity(HealthCheckResponse("hello, $name! Health check succeeded."), HttpStatus.OK)
    }

    @PostMapping(path = ["/users"], headers = ["Content-Type=application/json"])
    @Operation(summary = "Create a user.")
    fun createUser(
        @RequestBody(required = true)
        @Parameter(description = "A user information", example = "{username: Bob, mail_address: xyz@example.com}")
        body: UserRequest
    ): String {
        return "${body.userId}, ${body.username}"
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

    @GetMapping("/threads")
    @Operation(summary = "Get active threads.")
    fun getThreads(): String {
        return "Get threads"
    }

    @PostMapping("/threads")
    @Operation(summary = "Create a thread.")
    fun createThread(): String {
        return "Create a thread."
    }

    @GetMapping("/threads/{threadId}")
    @Operation(summary = "Get a thread and comments in the thread.")
    fun getThread(
        @Parameter(description = "thread id", required = true)
        @PathVariable("threadId")
        threadId: String
    ): String {
        return "Get a thread and comments in the thread."
    }

    @DeleteMapping("/threads/{threadId}")
    @Operation(summary = "Delete a thread and comments in the thread.")
    fun deleteThread(
        @Parameter(description = "thread id", required = true)
        @PathVariable("threadId")
        threadId: String
    ): String {
        return "Delete a thread and comments in the thread."
    }

    @PostMapping("/comments")
    @Operation(summary = "Create a comment.")
    fun createComment(): String {
        return "Create a comment."
    }

    @PutMapping("/comments/{commentId}")
    @Operation(summary = "Update a comment.")
    fun updateComment(
        @Parameter(description = "comment id", required = true)
        @PathVariable("commentId")
        commentId: String
    ): String {
        return "Update a comment."
    }

    @DeleteMapping("/comments/{commentId}")
    @Operation(summary = "Delete a comment.")
    fun deleteComment(
        @Parameter(description = "comment id", required = true)
        commentId: String
    ): String {
        return "Delete a comment."
    }
}