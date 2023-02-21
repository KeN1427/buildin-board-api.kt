package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.domain.User
import com.ken1427.bulletinboardapi.kt.service.user.UserRequest

interface UserRepository {
    fun get(userId: Int): User

    fun create(userData: UserRequest): User

    fun update(userId: Int, userData: UserRequest): User

    fun delete(userId: Int)
}