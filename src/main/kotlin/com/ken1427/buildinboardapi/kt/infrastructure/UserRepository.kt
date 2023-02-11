package com.ken1427.buildinboardapi.kt.infrastructure

import com.ken1427.buildinboardapi.kt.infrastructure.Dao.User

interface UserRepository {
    fun fetchUser(userId: Int)

    fun createUser(user: User)

    fun updateUser(user: User)

    fun deleteUser(userId: Int)
}

class UserRepositoryImpl: UserRepository {
    override fun fetchUser(userId: Int) {
        TODO("Not yet implemented")
    }

    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: Int) {
        TODO("Not yet implemented")
    }
}