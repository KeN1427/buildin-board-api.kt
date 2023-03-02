package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository

interface GetOpenThreadsUseCase {
    fun handle()
}

class GetOpenThreadsUseCaseImpl(
    private val threadRepository: ThreadRepository
): GetOpenThreadsUseCase {
    override fun handle() {
        TODO("Not yet implemented")
    }
}