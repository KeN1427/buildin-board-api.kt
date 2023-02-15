package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserInteractor(
    private val userRepository: UserRepository
): GetUserUseCase {
    override fun handle(userId: Int): UserResponse {
        TODO("Not yet implemented")
    }
}