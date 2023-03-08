package com.ken1427.bulletinboardapi.kt.usecase.comment

import com.ken1427.bulletinboardapi.kt.entity.Comment
import com.ken1427.bulletinboardapi.kt.entity.Thread
import java.time.LocalDateTime

data class CommentResponse(
    val commentId: Int,
    val userId: Int,
    val threadId: Int,
    val status: Comment.Companion.Status,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun create(comment: Comment) = CommentResponse(
            commentId = comment.id.value,
            userId = comment.userId,
            threadId = comment.threadId,
            status = Comment.Companion.Status.valueOf(comment.status),
            createdAt = comment.createdAt,
            updatedAt = comment.updatedAt
        )
    }
}