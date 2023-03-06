package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import org.springframework.stereotype.Service

interface DeleteThreadUseCase {
    fun handle(threadId: Int)
}

@Service
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