package br.com.rest.rest.mapper

import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<User, UserDTO> {
    override fun map(t: User): UserDTO {
        return UserDTO(
        id = t.id,
        name = t.name,
        email = t.email,
        password = t.password,
        admin = t.admin
        )
    }

}
