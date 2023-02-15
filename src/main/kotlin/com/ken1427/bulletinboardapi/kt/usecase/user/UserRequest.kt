package com.ken1427.bulletinboardapi.kt.usecase.user

data class UserRequest(
    val userId: Int?,
    val username: String?,
    val mailAddress: String?
)
