package br.com.rest.rest.repositories

import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.exception.NotFoundException
import br.com.rest.rest.model.User
import org.springframework.stereotype.Service

@Service
class UserRepository(
    private var users: List<User> = ArrayList()
) {
    private val notFoundMessage: String = "User not foud"

    fun create(user: User): User{
        users = users.plus(user)
        return user
    }

    fun get(): List<User>{
        return users
    }

    fun get(id: Long): User{
        return users.stream().findFirst().get()
    }

    fun update(user: User, dto: UpdateUserDTO): User {
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

    fun delete(user: User) {
        users = users.minus(user)
    }

    fun getUserbyId(id: Long): User =
        get()
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }

}