package com.ken1427.bulletinboardapi.kt.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "username", length = 30, nullable = false)
    val username: String = "username",
    @Column(name = "mail_address", length = 30, nullable = false)
    val mailAddress: String = "",
    @Column(name = "status", length = 30, nullable = false)
    val status: String = Status.ENABLE.name,
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    enum class Status{
        ENABLE,
        DISABLE
    }
}
