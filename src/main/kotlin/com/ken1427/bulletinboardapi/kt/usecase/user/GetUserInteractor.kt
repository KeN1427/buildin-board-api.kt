package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserInteractor(
    private val userRepository: UserRepository
): GetUserUseCase {
    override fun handle(userId: Int): UserResponse {
        val result = userRepository.findById(userId).get()
        return UserResponse.create(result)
    }
}