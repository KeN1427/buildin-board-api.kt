package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.domain.User

interface UserRepository {
    fun get(userId: Int): User
    fun create(user: User): User
}