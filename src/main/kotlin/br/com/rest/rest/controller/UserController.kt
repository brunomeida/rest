package br.com.rest.rest.controller


import br.com.rest.rest.controller.UserController.Companion.REQUEST
import br.com.rest.rest.dto.SingUpDTO
import br.com.rest.rest.dto.UpdateUserDTO
import br.com.rest.rest.dto.UserDTO
import br.com.rest.rest.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping(REQUEST)
class UserController(
    val userService: UserService
) {
    companion object{
        const val REQUEST = "/user"
        const val SING_UP = "/singup"
        const val ID = "/{id}"
    }

    @GetMapping
    fun get(): List<UserDTO> = userService.get()

    @GetMapping(ID)
    fun getById(@PathVariable id: Long): UserDTO = userService.get(id)

    @PutMapping
    fun put(@RequestBody @Valid dto: UpdateUserDTO): ResponseEntity<UserDTO> {
        val userDto = userService.put(dto)
        return ResponseEntity.ok(userDto)
    }

    @DeleteMapping(ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = userService.delete(id)

    @PostMapping(SING_UP)
    fun singUp(
        @RequestBody @Valid dto: SingUpDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UserDTO>{
        val userDto = userService.singUp(dto)
        val uri = uriBuilder.path(REQUEST.plus(userDto.id)).build().toUri()
        return ResponseEntity.created(uri).body(userDto)
    }
}