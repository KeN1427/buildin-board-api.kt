package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface CreateUserUseCase {
    fun handle(userData: UserRequest): UserResponse
}

class CreateUserUseCaseImpl(
    private val userRepository: UserRepository
): CreateUserUseCase {
    override fun handle(userData: UserRequest): UserResponse {
        val newUser = try {
            userRepository.createUser(userData)
        } catch (e: Exception) {
            throw e
        }
        return UserResponse.create(newUser)
    }
}