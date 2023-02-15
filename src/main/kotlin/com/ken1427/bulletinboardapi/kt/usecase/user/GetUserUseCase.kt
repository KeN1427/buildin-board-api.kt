package com.ken1427.bulletinboardapi.kt.usecase.user

interface GetUserUseCase {
    fun handle(userId: Int): UserResponse
}