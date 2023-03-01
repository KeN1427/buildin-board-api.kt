package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.entity.User
import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest

interface UserRepository {
    fun getUser(userId: Int): User

    fun getActiveUsers(): List<User>

    fun createUser(userData: UserRequest): User

    fun updateUser(userId: Int, userData: UserRequest): User

    fun deleteUser(userId: Int)

    fun restoreUser(userId: Int): User
}