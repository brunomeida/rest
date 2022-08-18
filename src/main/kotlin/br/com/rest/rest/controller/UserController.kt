package br.com.rest.rest.controller

import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.model.User
import br.com.rest.rest.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {

    @GetMapping
    fun get(): List<UserDTO> {
        return userService.get()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserDTO {
        return userService.get(id)
    }

    @PutMapping
    fun put(@RequestBody dto: UpdateUserDTO): UserDTO {
        return userService.put(dto)
    }

    @PostMapping
    fun singUp(
        @RequestBody @Valid dto: SingUpDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UserDTO>{
        val userDTO = userService.singUp(dto)
        val uri = uriBuilder.path("/user/${userDTO.id}").build().toUri()
        return ResponseEntity.created(uri).body(userDTO)
    }
}