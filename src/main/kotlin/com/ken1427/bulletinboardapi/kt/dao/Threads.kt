package com.ken1427.bulletinboardapi.kt.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Threads: IntIdTable() {
    val userId    = integer("user_id")
    val status      = varchar("status", 10)
    val createdAt   = datetime("created_at").default(LocalDateTime.now())
    val updatedAt   = datetime("updated_at").default(LocalDateTime.now())
}