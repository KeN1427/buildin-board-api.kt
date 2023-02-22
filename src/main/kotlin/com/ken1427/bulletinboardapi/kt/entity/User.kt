package com.ken1427.bulletinboardapi.kt.entity

import com.ken1427.bulletinboardapi.kt.dao.Users
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<User>(Users) {
        enum class Status {
            ACTIVE,
            INACTIVE
        }

        enum class Action {
            ACTIVATE,
            INACTIVATE
        }
    }

    var username by Users.username
    var mailAddress by Users.mailAddress
    var status by Users.status
    var createdAt by Users.createdAt
    var updatedAt by Users.updatedAt
}
