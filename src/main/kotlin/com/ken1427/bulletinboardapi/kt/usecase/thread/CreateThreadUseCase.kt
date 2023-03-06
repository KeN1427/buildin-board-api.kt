package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import org.springframework.stereotype.Service

interface CreateThreadUseCase {
    fun handle(userId: Int): ThreadResponse
}

@Service
class CreateThreadUseCaseImpl(
    private val threadRepository: ThreadRepository
): CreateThreadUseCase {
    override fun handle(userId: Int): ThreadResponse {
        val newThread = try {
            threadRepository.createThread(userId)
        } catch (e: Exception) {
            throw e
        }

        return ThreadResponse.create(newThread)
    }
}