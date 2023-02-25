package com.ken1427.bulletinboardapi.kt.entity

import com.ken1427.bulletinboardapi.kt.dao.Threads
import com.ken1427.bulletinboardapi.kt.dao.Users
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Thread(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Thread>(Threads) {
        enum class Status {
            OPEN,
            CLOSE
        }
    }

    var userId by Threads.userId
    var status by Threads.status
    var createdAt by Threads.createdAt
    var updatedAt by Threads.updatedAt
}
