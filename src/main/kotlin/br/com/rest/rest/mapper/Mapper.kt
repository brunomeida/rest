package br.com.rest.rest.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
