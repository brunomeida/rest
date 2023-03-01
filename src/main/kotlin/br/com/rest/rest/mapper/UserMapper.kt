package br.com.rest.rest.mapper

import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.model.Login
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<Login, UserDTO> {
    override fun map(t: Login): UserDTO {
        return UserDTO(
        id = t.id,
        name = t.name,
        email = t.email,
        password = t.password
        )
    }

}
