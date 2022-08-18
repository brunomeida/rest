package br.com.rest.rest.model

import java.time.LocalDateTime

data class User(
    var id: Long = 1,
    val name: String,
    val email: String,
    val password: String,
    val admin: Boolean = false,
    val registry: LocalDateTime = LocalDateTime.now()
)
