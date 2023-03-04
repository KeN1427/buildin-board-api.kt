package com.ken1427.bulletinboardapi.kt.usecase.thread

import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import com.ken1427.bulletinboardapi.kt.usecase.user.CreateUserUseCase
import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest
import com.ken1427.bulletinboardapi.kt.usecase.user.UserResponse

interface CreateThreadUseCase {
    fun handle(userId: Int)
}

class CreateThreadUseCaseImpl(
    private val threadRepository: ThreadRepository
): CreateThreadUseCase {
    override fun handle(userId: Int) {
        TODO("Not yet implemented")
    }
}