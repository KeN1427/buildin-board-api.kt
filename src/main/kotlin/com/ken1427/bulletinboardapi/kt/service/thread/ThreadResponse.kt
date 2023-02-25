package com.ken1427.bulletinboardapi.kt.service.thread

import com.ken1427.bulletinboardapi.kt.entity.Thread
import java.time.LocalDateTime

data class ThreadResponse(
    val threadId: Int,
    val userId: Int,
    val status: Thread.Companion.Status,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun create(thread: Thread) = ThreadResponse(
            threadId = thread.id.value,
            userId = thread.userId,
            status = Thread.Companion.Status.valueOf(thread.status),
            createdAt = thread.createdAt,
            updatedAt = thread.updatedAt
        )
    }
}