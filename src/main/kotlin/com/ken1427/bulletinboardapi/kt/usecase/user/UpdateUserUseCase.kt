package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface UpdateUserUseCase {
    fun handle(userId: Int, userData: UserRequest): UserResponse
}

class UpdateUserUseCaseImpl(
    private val userRepository: UserRepository
): UpdateUserUseCase {
    override fun handle(userId: Int, userData: UserRequest): UserResponse {
        val updatedUser = userRepository.updateUser(userId, userData)
        return UserResponse.create(updatedUser)
    }
}