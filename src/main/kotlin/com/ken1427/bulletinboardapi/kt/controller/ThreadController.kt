package com.ken1427.bulletinboardapi.kt.controller

import com.ken1427.bulletinboardapi.kt.usecase.thread.CreateThreadUseCase
import com.ken1427.bulletinboardapi.kt.usecase.thread.DeleteThreadUseCase
import com.ken1427.bulletinboardapi.kt.usecase.thread.GetOpenThreadsUseCase
import com.ken1427.bulletinboardapi.kt.usecase.thread.GetThreadUseCase
import com.ken1427.bulletinboardapi.kt.usecase.thread.ThreadResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Null

@RestController
@RequestMapping("/v1")
class ThreadController(
    private val createThreadUseCase: CreateThreadUseCase,
    private val deleteThreadUseCase: DeleteThreadUseCase,
    private val getOpenThreadsUseCase: GetOpenThreadsUseCase,
    private val getThreadUseCase: GetThreadUseCase,
) {
    @GetMapping("/threads")
    @Operation(summary = "Get active threads.")
    fun getThreads(): ResponseEntity<List<ThreadResponse>> {
        val result = getOpenThreadsUseCase.handle()

        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping("/threads")
    @Operation(summary = "Create a thread.")
    fun createThread(
        @Parameter(description = "user id", required = true)
        @PathVariable("userId")
        userId: String
    ): ResponseEntity<ThreadResponse> {
        val result = createThreadUseCase.handle(userId.toInt())

        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("/threads/{threadId}")
    @Operation(summary = "Get a thread and comments in the thread.")
    fun getThread(
        @Parameter(description = "thread id", required = true)
        @PathVariable("threadId")
        threadId: String
    ): ResponseEntity<ThreadResponse> {
        val result = getThreadUseCase.handle(threadId.toInt())

        return ResponseEntity(result, HttpStatus.OK)
    }

    @DeleteMapping("/threads/{threadId}")
    @Operation(summary = "Delete a thread and comments in the thread.")
    fun deleteThread(
        @Parameter(description = "thread id", required = true)
        @PathVariable("threadId")
        threadId: String
    ): ResponseEntity<Null> {
        deleteThreadUseCase.handle(threadId.toInt())

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}