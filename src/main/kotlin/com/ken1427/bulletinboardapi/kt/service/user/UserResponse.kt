package com.ken1427.bulletinboardapi.kt.service.user

import com.ken1427.bulletinboardapi.kt.entity.User
import com.ken1427.bulletinboardapi.kt.entity.User.Companion.Status
import java.time.LocalDateTime

data class UserResponse(
    val userId: Int,
    val username: String,
    val mailAddress: String,
    val status: Status,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun create(user: User) = UserResponse(
            userId = user.id.value,
            username = user.username,
            mailAddress = user.mailAddress,
            status = Status.valueOf(user.status),
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}
