package com.ken1427.bulletinboardapi.kt.domain

data class User(
    val id: Int? = null,
    val username: String,
    val mailAddress: String,
    val status: Status,
    val createdAt: Long? = null,
    val updatedAt: Long? = null
) {
    enum class Status {
        ENABLE,
        DISABLE
    }
}
