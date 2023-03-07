package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.dao.Comments
import com.ken1427.bulletinboardapi.kt.dao.Threads
import com.ken1427.bulletinboardapi.kt.entity.Comment
import com.ken1427.bulletinboardapi.kt.entity.Thread
import com.ken1427.bulletinboardapi.kt.shared.config.DBConfig
import com.ken1427.bulletinboardapi.kt.usecase.comment.CommentRequest
import org.jetbrains.exposed.dao.flushCache
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

interface CommentRepository {
    fun getComment(commentId: Int): Comment
    fun createComment(commentRequest: CommentRequest): Comment
    fun deleteComment(commentId: Int)
}

@Repository
class CommentRepositoryImpl: CommentRepository {
    @Autowired
    lateinit var dbConfig: DBConfig
    override fun getComment(commentId: Int): Comment {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            Comment.find { Comments.id eq commentId }.single()
        }
    }

    override fun createComment(commentRequest: CommentRequest): Comment {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            val newComment = Comment.new {
                this.userId = commentRequest.userId
                this.threadId = commentRequest.threadId
                this.status = Thread.Companion.Status.OPEN.name
            }
            flushCache()

            Comment.find { Comments.id eq newComment.id }.single()
        }
    }

    override fun deleteComment(commentId: Int) {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        transaction {
            addLogger(StdOutSqlLogger)

            Comment.find { Comments.id eq commentId }.single().also { thread ->
                thread.delete()
            }
        }
    }
}