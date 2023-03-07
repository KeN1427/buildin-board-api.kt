package com.ken1427.bulletinboardapi.kt.usecase.comment

data class CommentRequest(
    val userId: Int,
    val threadId: Int
)