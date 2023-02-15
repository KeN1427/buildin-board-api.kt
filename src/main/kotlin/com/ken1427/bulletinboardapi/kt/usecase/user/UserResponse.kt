package com.ken1427.bulletinboardapi.kt.usecase.user

import com.ken1427.bulletinboardapi.kt.domain.User

data class UserResponse(
    val userId: Int?,
    val username: String,
    val mailAddress: String,
    val status: User.Status,
    val createdAt: Long?,
    val updatedAt: Long?
) {
    companion object {
        fun create(user: User) = UserResponse(
            userId = user.id,
            username = user.username,
            mailAddress = user.mailAddress,
            status = user.status,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}
