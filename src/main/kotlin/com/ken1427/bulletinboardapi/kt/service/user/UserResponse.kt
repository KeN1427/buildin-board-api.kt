package com.ken1427.bulletinboardapi.kt.service.user

import com.ken1427.bulletinboardapi.kt.domain.User
import java.time.LocalDateTime

data class UserResponse(
    val userId: Int,
    val username: String,
    val mailAddress: String,
    val status: User.Status,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun create(user: User) = UserResponse(
            userId = user.id,
            username = user.username,
            mailAddress = user.mailAddress,
            status = User.Status.valueOf(user.status),
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}
