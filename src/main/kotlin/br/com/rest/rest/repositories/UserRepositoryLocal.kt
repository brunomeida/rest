package br.com.rest.rest.repositories

import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.exception.NotFoundException
import br.com.rest.rest.model.Login
import org.springframework.stereotype.Service

@Service
class UserRepositoryLocal(
    private var logins: List<Login> = ArrayList()
) {
    private val notFoundMessage: String = "User not foud"

    fun create(login: Login): Login{
        logins = logins.plus(login)
        return login
    }

    fun get(): List<Login>{
        return logins
    }

    fun get(id: Long): Login{
        return getUserbyId(id)
    }

    fun update(login: Login, dto: UpdateUserDTO): Login {
        val loginUpdated = Login(
            id = dto.id,
            name = dto.name,
            email = dto.email,
            password = dto.password
        )
        logins = logins.minus(login).plus(loginUpdated)
        return loginUpdated
    }

    fun delete(login: Login) {
        logins = logins.minus(login)
    }

    fun getUserbyId(id: Long): Login =
        get()
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }

}