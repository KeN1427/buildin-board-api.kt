package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CreateUserInteractor(
    private val userRepository: UserRepository
) : CreateUserUseCase {
    override fun handle(body: UserRequest): UserResponse {
        // Validate the request.
        val username = body.username ?: throw Exception()
        val mailAddress = body.mailAddress ?: throw Exception()

        val result = userRepository.saveAndFlush(
            User(
                username = username,
                mailAddress = mailAddress
            )
        )

        return UserResponse.create(result)
    }
}