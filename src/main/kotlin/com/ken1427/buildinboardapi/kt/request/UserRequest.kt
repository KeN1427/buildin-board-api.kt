package com.ken1427.buildinboardapi.kt.request

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