package br.com.rest.rest.dto

data class UserDTO(
    var id: Long,
    val name: String,
    val email: String,
    val password: String,
    val admin: Boolean
)
