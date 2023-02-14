package com.ken1427.bulletinboardapi.kt.request

data class UserRequest (
    val userId: Int?,
    val username: String,
    val mailAddress: String,
    val status: Status?
) {
    enum class Status {
        ENABLE,
        DISABLE
    }
}