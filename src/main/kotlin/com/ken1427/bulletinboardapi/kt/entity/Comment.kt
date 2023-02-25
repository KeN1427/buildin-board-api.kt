package com.ken1427.bulletinboardapi.kt.entity

import com.ken1427.bulletinboardapi.kt.dao.Comments
import com.ken1427.bulletinboardapi.kt.dao.Threads
import com.ken1427.bulletinboardapi.kt.dao.Users
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Comment(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Comment>(Comments) {
        enum class Status {
            OPEN,
            CLOSE
        }
    }

    var userId by Comments.userId
    var threadId by Comments.threadId
    var status by Comments.status
    var createdAt by Comments.createdAt
    var updatedAt by Comments.updatedAt
}
