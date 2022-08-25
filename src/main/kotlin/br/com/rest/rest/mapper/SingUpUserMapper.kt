package br.com.rest.rest.mapper

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.model.Login
import org.springframework.stereotype.Component

@Component
class SingUpUserMapper: Mapper<SingUpDTO, Login> {
    override fun map(t: SingUpDTO): Login {
        return Login(
            name = t.name,
            email = t.email,
            password = t.password,
        )
    }
}