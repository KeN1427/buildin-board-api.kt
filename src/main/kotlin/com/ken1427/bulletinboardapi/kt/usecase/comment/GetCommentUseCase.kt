package com.ken1427.bulletinboardapi.kt.usecase.comment

import com.ken1427.bulletinboardapi.kt.repository.CommentRepository
import org.springframework.stereotype.Service

interface GetCommentUseCase {
    fun handle(commentId: Int): CommentResponse
}

@Service
class GetCommentUseCaseImpl(
    private val commentRepository: CommentRepository
): GetCommentUseCase {
    override fun handle(commentId: Int): CommentResponse {
        val comment = try {
            commentRepository.getComment(commentId)
        } catch (e: Exception) {
            throw e
        }

        return CommentResponse.create(comment)
    }
}