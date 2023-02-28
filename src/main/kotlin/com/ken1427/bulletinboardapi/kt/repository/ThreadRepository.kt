package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.entity.Thread

interface ThreadRepository {
    fun getThread(threadId: Int): Thread

    fun getOpenThreads(): List<Thread>

    fun createThread(userId: Int): Thread

    fun deleteThread(threadId: Int)
}