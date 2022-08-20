package br.com.rest.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class SingUpDTO(
    @field:NotEmpty(message = "name must not be null")
    val name: String,

    @field:NotEmpty(message = "email must not be null")
    val email: String,

    @field:NotEmpty(message = "password must not be null")
    @field:Size(min=6, max=256)
    val password: String,

    val admin: Boolean = false
)
