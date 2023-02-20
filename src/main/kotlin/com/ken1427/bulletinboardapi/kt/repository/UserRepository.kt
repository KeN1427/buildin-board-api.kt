package com.ken1427.bulletinboardapi.kt.repository

import com.ken1427.bulletinboardapi.kt.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int> {}