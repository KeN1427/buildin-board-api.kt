package com.ken1427.bulletinboardapi.kt.usecase.comment

import com.ken1427.bulletinboardapi.kt.repository.CommentRepository
import org.springframework.stereotype.Service

interface DeleteCommentUseCase {
    fun handle(commentId: Int)
}

@Service
class DeleteCommentUseCaseImpl(
    private val commentRepository: CommentRepository
): DeleteCommentUseCase {
    override fun handle(commentId: Int) {
        try {
            commentRepository.deleteComment(commentId)
        } catch (e: Exception) {
            throw e
        }
    }
}