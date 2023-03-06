package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import org.springframework.stereotype.Service

interface GetOpenThreadsUseCase {
    fun handle(): List<ThreadResponse>
}

@Service
class GetOpenThreadsUseCaseImpl(
    private val threadRepository: ThreadRepository
): GetOpenThreadsUseCase {
    override fun handle(): List<ThreadResponse> {
        val threadList = try {
            threadRepository.getOpenThreads()
        } catch (e: Exception) {
            throw e
        }

        return threadList.map { ThreadResponse.create(it) }
    }
}