package com.ken1427.bulletinboardapi.kt.service.user

import com.ken1427.bulletinboardapi.kt.entity.User
import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun get(userId: Int): UserResponse {
        val user = userRepository.get(userId)
        return UserResponse.create(user)
    }

    override fun getAll(): List<UserResponse> {
        val users = userRepository.getAll()
        return users.map { UserResponse.create(it) }
    }

    override fun create(userData: UserRequest): UserResponse {
        val newUser = userRepository.create(userData)
        return UserResponse.create(newUser)
    }

    override fun update(userId: Int, userData: UserRequest): UserResponse {
        val updatedUser = userRepository.update(userId, userData)
        return UserResponse.create(updatedUser)
    }

    override fun delete(userId: Int) {
        userRepository.delete(userId)
    }

    override fun restore(userId: Int): UserResponse {
        val user = userRepository.restore(userId)
        return UserResponse.create(user)
    }
}