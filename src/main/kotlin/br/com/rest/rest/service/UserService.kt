package br.com.rest.rest.service

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.dto.UserDTO

interface UserService {
    fun get(): List<UserDTO>
    fun get(id: Long): UserDTO
    fun singUp(dto: SingUpDTO): UserDTO
    fun put(dto: UpdateUserDTO): UserDTO
}