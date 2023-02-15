package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CreateUserInteractor(
    private val userRepository: UserRepository
) : CreateUserUseCase {
    override fun handle(user: UserRequest): UserResponse {
        // Validate the request.
        val username = user.username ?: throw Exception()
        val mailAddress = user.mailAddress ?: throw Exception()

        val newUser = User(
            username = username,
            mailAddress = mailAddress,
            status = User.Status.ENABLE
        )
        val result = userRepository.create(newUser)
        return UserResponse.create(result)
    }
}