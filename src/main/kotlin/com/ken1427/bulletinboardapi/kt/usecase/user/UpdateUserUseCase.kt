package com.ken1427.bulletinboardapi.kt.usecase.user

interface UpdateUserUseCase {
    fun handle(userId: Int, userData: UserRequest): UserResponse
}