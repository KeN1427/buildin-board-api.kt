package com.ken1427.bulletinboardapi.kt.usecase.user

interface UpdateUserUseCase {
    fun handle(user: UserRequest): UserResponse
}