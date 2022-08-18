package br.com.rest.rest.service.impl

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.mapper.SingUpUserMapper
import br.com.rest.rest.mapper.UserMapper
import br.com.rest.rest.model.User
import br.com.rest.rest.service.UserService
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class UserServiceImpl(
    private var users: List<User> = ArrayList(),
    private var singUpUserMapper: SingUpUserMapper,
    private val userMapper: UserMapper
): UserService {

    override fun get(): List<UserDTO> {
        return users.stream().map{
            t -> userMapper.map(t)
        }.collect(Collectors.toList())
    }

    override fun get(id: Long): UserDTO {
        return users.stream().map {
                user -> userMapper.map(user)
        }.findFirst().get()
    }

    override fun singUp(dto: SingUpDTO): UserDTO {
        val user = singUpUserMapper.map(dto)
        users = users.plus(user)
        return userMapper.map(user)
    }

    override fun put(dto: UpdateUserDTO): UserDTO {
        val user = getUserbyId(dto.id)
        val userUpdated = update(user, dto)
        return userMapper.map(userUpdated)

    }

    private fun getUserbyId(id: Long): User =
        users.stream().filter { t -> t.id == id }.findFirst().get()

    private fun update(user: User, dto: UpdateUserDTO): User {
        val userUpdated = User(
            id = dto.id,
            name = dto.name,
            email = dto.email,
            password = dto.password,
            admin = dto.admin
        )
        users = users.minus(user).plus(userUpdated)
        return userUpdated
    }
}
