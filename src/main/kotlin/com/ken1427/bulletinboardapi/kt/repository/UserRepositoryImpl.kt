package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.entity.User
import com.ken1427.bulletinboardapi.kt.dao.Users
import com.ken1427.bulletinboardapi.kt.usecase.user.UserRequest
import com.ken1427.bulletinboardapi.kt.shared.config.DBConfig
import org.jetbrains.exposed.dao.flushCache
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl: UserRepository {
    @Autowired
    lateinit var dbConfig: DBConfig
    override fun getUser(userId: Int): User {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            User.find { Users.id eq userId }.single()
        }
    }

    override fun getActiveUsers(): List<User> {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            User.find {
                Users.status eq User.Companion.Status.ACTIVE.name
            }.map { it }
        }
    }

    override fun createUser(userData: UserRequest): User {
        val username = userData.username ?: throw Exception()
        val mailAddress = userData.mailAddress ?: throw Exception()

        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            val newUser = User.new {
                this.username = username
                this.mailAddress = mailAddress
                this.status = User.Companion.Status.ACTIVE.name
            }
            flushCache()

            User.find { Users.id eq newUser.id }.single()
        }
    }

    override fun updateUser(userId: Int, userData: UserRequest): User {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            User.find { Users.id eq userId }.single().also { user ->
                userData.username?.let { user.username = it }
                userData.mailAddress?.let { user.mailAddress = it }
            }
        }
    }

    override fun deleteUser(userId: Int) {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        transaction {
            addLogger(StdOutSqlLogger)

            User.find { Users.id eq userId }.single().also { user ->
                user.status = User.Companion.Status.INACTIVE.name
            }
        }
    }

    override fun restoreUser(userId: Int): User {
        Database.connect(dbConfig.url, dbConfig.driverClassName, dbConfig.username, dbConfig.password)
        return transaction {
            addLogger(StdOutSqlLogger)

            User.find { Users.id eq userId }.single().also { user ->
                user.status = User.Companion.Status.ACTIVE.name
            }
        }
    }
}