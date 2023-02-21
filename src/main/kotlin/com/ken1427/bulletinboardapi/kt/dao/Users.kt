package com.ken1427.bulletinboardapi.kt.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Users: IntIdTable() {
    val username    = varchar("username", 30).index()
    val mailAddress = varchar("mail_address", 30)
    val status      = varchar("status", 10)
    val createdAt   = datetime("created_at").default(LocalDateTime.now())
    val updatedAt   = datetime("updated_at").default(LocalDateTime.now())
}