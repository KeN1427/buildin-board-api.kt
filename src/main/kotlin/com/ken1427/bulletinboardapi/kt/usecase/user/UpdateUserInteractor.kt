package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UpdateUserInteractor(
    private val userRepository: UserRepository
): UpdateUserUseCase {
    override fun handle(userId: Int, userData: UserRequest): UserResponse {
        val user = userRepository.findById(userId)
        val result = userRepository.saveAndFlush(
            User(
                id = userId,
                username = userData.username ?: user.get().username,
                mailAddress = userData.mailAddress ?: user.get().mailAddress
            )
        )

        return UserResponse.create(result)
    }
}