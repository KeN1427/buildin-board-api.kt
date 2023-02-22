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

    override fun getActiveUsers(): List<UserResponse> {
        val users = userRepository.getActiveUsers()
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

    override fun updateStatus(userId: Int, action: String) {
        val status = when(User.Companion.Action.valueOf(action.uppercase())) {
            User.Companion.Action.ACTIVATE -> User.Companion.Status.ACTIVE
            User.Companion.Action.INACTIVATE -> User.Companion.Status.INACTIVE
        }
        userRepository.updateStatus(userId, status.name)
    }
}