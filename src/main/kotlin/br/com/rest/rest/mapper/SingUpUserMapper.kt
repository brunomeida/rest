package br.com.rest.rest.mapper

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.model.User
import org.springframework.stereotype.Component

@Component
class SingUpUserMapper: Mapper<SingUpDTO, User> {
    override fun map(t: SingUpDTO): User {
        return User(
            name = t.name,
            email = t.email,
            password = t.password,
            admin = t.admin
        )
    }
}