package com.ken1427.bulletinboardapi.kt.service.user

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun get(userId: Int): UserResponse {
        val result = userRepository.findById(userId).get()
        return UserResponse.create(result)
    }

    override fun create(userData: UserRequest): UserResponse {
        // Validate the request.
        val username = userData.username ?: throw Exception()
        val mailAddress = userData.mailAddress ?: throw Exception()

        val result = userRepository.saveAndFlush(
            User(
                username = username,
                mailAddress = mailAddress
            )
        )

        return UserResponse.create(result)
    }

    override fun update(userId: Int, userData: UserRequest): UserResponse {
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

    override fun delete(userId: Int) {
        userRepository.deleteById(userId)
    }
}