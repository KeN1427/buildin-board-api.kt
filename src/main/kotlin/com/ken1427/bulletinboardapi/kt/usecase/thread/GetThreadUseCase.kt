package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import org.springframework.stereotype.Service

interface GetThreadUseCase {
    fun handle(threadId: Int): ThreadResponse
}

@Service
class GetThreadUseCaseImpl(
    private val threadRepository: ThreadRepository
): GetThreadUseCase {
    override fun handle(threadId: Int): ThreadResponse {
        val thread = try {
            threadRepository.getThread(threadId)
        } catch (e: Exception) {
            throw e
        }

        return ThreadResponse.create(thread)
    }

}