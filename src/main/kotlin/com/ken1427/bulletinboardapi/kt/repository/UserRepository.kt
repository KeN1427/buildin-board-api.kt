package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.entity.User
import com.ken1427.bulletinboardapi.kt.service.user.UserRequest

interface UserRepository {
    fun get(userId: Int): User

    fun create(userData: UserRequest): User

    fun update(userId: Int, userData: UserRequest): User

    fun updateStatus(userId: Int, status: String)

    fun delete(userId: Int)
}