package br.com.rest.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateUserDTO(
    @field:NotNull(message = "id must not be null")
    val id: Long,

    @field:NotEmpty(message = "name must not be null")
    val name: String,

    @field:NotEmpty(message = "email must not be null")
    val email: String,

    @field:NotEmpty(message = "password too short")
    @field:Size(min=6, max=256)
    val password: String,

    val admin: Boolean = false
)
