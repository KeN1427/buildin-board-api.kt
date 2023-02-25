package com.ken1427.bulletinboardapi.kt.service.thread

interface ThreadService {
    fun get(threadId: Int): ThreadResponse

    fun getOpenThreads(): List<ThreadResponse>

    fun create(userId: Int): ThreadResponse

    fun delete(threadId: Int)
}