package br.com.rest.rest.dto

import java.time.LocalDateTime

data class UserErrorDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
