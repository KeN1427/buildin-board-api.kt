package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.domain.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl: UserRepository {
    override fun get(userId: Int): User {
        TODO("Not yet implemented")
    }

    override fun create(user: User): User {
        // TODO: DBへ登録処理

        // TODO: DBに登録した情報を返却（特にid, createdAt, updatedAt）
        return User(
            id = null,
            username = "",
            mailAddress = "",
            status = User.Status.ENABLE,
            createdAt = null,
            updatedAt = null
        )
    }
}