package com.ken1427.bulletinboardapi.kt.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class CommentController {
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