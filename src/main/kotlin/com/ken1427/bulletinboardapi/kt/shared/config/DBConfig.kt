package com.ken1427.bulletinboardapi.kt.shared.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("spring.datasource")
data class DBConfig(
    val driverClassName: String,
    val url: String,
    val username: String,
    val password: String
)