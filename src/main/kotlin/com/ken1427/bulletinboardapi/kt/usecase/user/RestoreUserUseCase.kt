package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface RestoreUserUseCase {
    fun handle(userId: Int): UserResponse
}

class RestoreUserUseCaseImpl(
    private val userRepository: UserRepository
): RestoreUserUseCase {
    override fun handle(userId: Int): UserResponse {
        val user = try {
            userRepository.restoreUser(userId)
        } catch (e: Exception) {
            throw e
        }
        return UserResponse.create(user)
    }
}