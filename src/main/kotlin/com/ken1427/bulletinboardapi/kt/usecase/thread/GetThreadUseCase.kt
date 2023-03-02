package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository

interface GetThreadUseCase {
    fun handle(threadId: Int)
}

class GetThreadUseCaseImpl(
    private val threadRepository: ThreadRepository
): GetThreadUseCase {
    override fun handle(threadId: Int) {
        TODO("Not yet implemented")
    }

}