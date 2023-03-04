package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository

interface DeleteThreadUseCase {
    fun handle(threadId: Int)
}

class DeleteThreadUseCaseImpl(
    private val threadRepository: ThreadRepository
): DeleteThreadUseCase {
    override fun handle(threadId: Int) {
        try {
            threadRepository.deleteThread(threadId)
        } catch (e: Exception) {
            throw e
        }
    }
}