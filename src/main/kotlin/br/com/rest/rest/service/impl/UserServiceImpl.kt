package br.com.rest.rest.service.impl

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.mapper.SingUpUserMapper
import br.com.rest.rest.mapper.UserMapper
import br.com.rest.rest.repositories.UserRepository
import br.com.rest.rest.service.UserService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserServiceImpl(
    private var singUpUserMapper: SingUpUserMapper,
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
): UserService {

    override fun get(): List<UserDTO> {
        return userRepository.findAll()
            .stream()
            .map{ t -> userMapper.map(t) }
            .collect(Collectors.toList())
    }

    override fun get(id: Long): UserDTO = userMapper.map(userRepository.getReferenceById(id))

    override fun singUp(dto: SingUpDTO): UserDTO {
        val user = singUpUserMapper.map(dto)
        val createdUser = userRepository.save(user)
        return userMapper.map(createdUser)
    }

    override fun put(dto: UpdateUserDTO): UserDTO {
        val user = userRepository.getReferenceById(dto.id)
        user.email = dto.email
        user.name = dto.name
        val userUpdated = userRepository.save(user)
        return userMapper.map(userUpdated)
    }

    override fun delete(id: Long) {
        userRepository.delete(
            userRepository.getReferenceById(id)
        )
    }
}
