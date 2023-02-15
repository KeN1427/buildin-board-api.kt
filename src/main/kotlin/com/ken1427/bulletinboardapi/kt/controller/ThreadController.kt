package com.ken1427.bulletinboardapi.kt.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class ThreadController {
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

}