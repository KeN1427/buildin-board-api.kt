package com.ken1427.bulletinboardapi.kt.usecase.comment

import com.ken1427.bulletinboardapi.kt.repository.CommentRepository
import com.ken1427.bulletinboardapi.kt.repository.ThreadRepository
import org.springframework.stereotype.Service

interface CreateCommentUseCase {
    fun handle(commentRequest: CommentRequest): CommentResponse
}

@Service
class CreateCommentUseCaseImpl(
    private val commentRepository: CommentRepository
): CreateCommentUseCase {
    override fun handle(commentRequest: CommentRequest): CommentResponse {
        val newComment = try {
            commentRepository.createComment(commentRequest)
        } catch (e: Exception) {
            throw e
        }

        return CommentResponse.create(newComment)
    }
}