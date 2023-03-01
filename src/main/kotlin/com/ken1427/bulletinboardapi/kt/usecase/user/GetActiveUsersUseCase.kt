package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository

interface GetActiveUsersUseCase {
    fun handle(): List<UserResponse>
}

class GetActiveUsersUseCaseImpl(
    private val userRepository: UserRepository
): GetActiveUsersUseCase {
    override fun handle(): List<UserResponse> {
        val users = try {
            userRepository.getActiveUsers()
        } catch (e: Exception) {
            throw e
        }
        return users.map { UserResponse.create(it) }
    }

}