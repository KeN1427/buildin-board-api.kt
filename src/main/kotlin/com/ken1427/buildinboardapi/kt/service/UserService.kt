package com.ken1427.buildinboardapi.kt.service

import com.ken1427.buildinboardapi.kt.request.UserRequest

interface UserService {
    fun getUser(userId: Int)

    fun createUser(user: UserRequest)

    fun updateUser(user: UserRequest)

    fun deleteUser(userId: Int)
}

class UserServiceImpl: UserService {
    override fun getUser(userId: Int) {
        TODO("Not yet implemented")
    }

    override fun createUser(user: UserRequest) {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: UserRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: Int) {
        TODO("Not yet implemented")
    }
}