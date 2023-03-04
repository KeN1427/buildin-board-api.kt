package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import com.ken1427.bulletinboardapi.kt.usecase.user.CreateUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest
import com.ken1427.bulletinboardapi.kt.usecase.user.UserResponse

interface CreateThreadUseCase {
    fun handle(userId: Int): ThreadResponse
}

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