package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface DeleteUserUseCase {
    fun handle(userId: Int)
}

class DeleteUserUseCaseImpl(
    private val userRepository: UserRepository
): DeleteUserUseCase {
    override fun handle(userId: Int) {
        userRepository.deleteUser(userId)
    }
}