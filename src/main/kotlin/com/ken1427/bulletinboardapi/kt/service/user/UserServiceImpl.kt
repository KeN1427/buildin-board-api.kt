package com.ken1427.bulletinboardapi.kt.service.user

import com.ken1427.bulletinboardapi.kt.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun get(userId: Int): UserResponse {
        val user = userRepository.getUser(userId)
        return UserResponse.create(user)
    }

    override fun getAll(): List<UserResponse> {
        val users = userRepository.getActiveUsers()
        return users.map { UserResponse.create(it) }
    }

    override fun create(userData: UserRequest): UserResponse {
        val newUser = userRepository.createUser(userData)
        return UserResponse.create(newUser)
    }

    override fun update(userId: Int, userData: UserRequest): UserResponse {
        val updatedUser = userRepository.updateUser(userId, userData)
        return UserResponse.create(updatedUser)
    }

    override fun delete(userId: Int) {
        userRepository.deleteUser(userId)
    }

    override fun restore(userId: Int): UserResponse {
        val user = userRepository.restoreUser(userId)
        return UserResponse.create(user)
    }
}