package br.com.rest.rest.service.impl

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.mapper.SingUpUserMapper
import br.com.rest.rest.mapper.UserMapper
import br.com.rest.rest.repositories.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LoginServiceImplTest {
    @RelaxedMockK
    lateinit var singUpUserMapper: SingUpUserMapper

    @RelaxedMockK
    lateinit var userMapper: UserMapper

    @RelaxedMockK
    lateinit var userRepository: UserRepository

    @RelaxedMockK
    lateinit var userServiceImpl: UserServiceImpl


    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        userServiceImpl = UserServiceImpl(singUpUserMapper,userMapper,userRepository)
    }

    @Test
    fun get() {
        userServiceImpl.get()
    }

    @Test
    fun singUp() {
        assertThrows<ClassCastException> { userServiceImpl.singUp(SingUpDTO(
            name = "bruno",
            email = "bruno@bruno",
            password = "senhaforte"
        )) }
    }


    @Test
    fun put() {
        assertThrows<ClassCastException> {
            userServiceImpl.put(
                UpdateUserDTO(
                    id = 1,
                    name = "bruno",
                    email = "bruno@bruno",
                    password = "senhaforte"
                )
            )
        }
    }

    @Test
    fun delete() {
        assertThrows<ClassCastException> {
            userServiceImpl.delete(1)
        }
    }
}