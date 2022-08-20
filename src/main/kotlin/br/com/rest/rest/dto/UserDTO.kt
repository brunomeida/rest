package br.com.rest.rest.dto

data class UserDTO(
    var id: Long?,
    var name: String,
    var email: String,
    val password: String
)
