package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.entity.Thread

interface ThreadRepository {
    fun get(threadId: Int): Thread

    fun getOpenThreads(): List<Thread>

    fun create(userId: Int): Thread

    fun delete(threadId: Int)
}