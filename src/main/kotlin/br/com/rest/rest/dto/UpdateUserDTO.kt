package br.com.rest.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateUserDTO(
    @field:NotNull
    val id: Long,

    @field:NotEmpty
    val name: String,

    @field:NotEmpty
    val email: String,

    @field:NotEmpty
    @field:Size(min=6, max=256)
    val password: String,

    val admin: Boolean = false
)
