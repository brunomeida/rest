package br.com.rest.rest.mapper.extensions

import java.math.BigDecimal

fun String.parseToBigDecimal(): BigDecimal {
    return try {
        BigDecimal(this.replace(".", "").replace(",", "."))
    } catch (e: Exception) {
        throw IllegalArgumentException("Invalid number format")
    }
}