package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface GetUserUseCase {
    fun handle(userId: Int): UserResponse
}

class GetUserUseCaseImpl(
    private val userRepository: UserRepository
): GetUserUseCase {
    override fun handle(userId: Int): UserResponse {
        val user = try {
            userRepository.getUser(userId)
        } catch (e: Exception) {
            throw e
        }
        return UserResponse.create(user)
    }

}
