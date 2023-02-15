package com.ken1427.bulletinboardapi.kt.usecase.user

interface CreateUserUseCase {
    fun handle(user: UserRequest): UserResponse
}
