package br.com.rest.rest.exception

import br.com.rest.rest.dto.UserErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBeanValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): UserErrorDTO {
        val errorMessage = HashMap<String, String?>()

        exception.bindingResult.fieldErrors.forEach{
            e -> errorMessage.put(e.field, e.defaultMessage)
        }

        return buildUserErrorDTO(
            errorMessage,
            request
        )
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): UserErrorDTO {
        return buildUserErrorDTO(
            HttpStatus.NOT_FOUND,
            exception,
            request
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): UserErrorDTO {
        return buildUserErrorDTO(
            HttpStatus.INTERNAL_SERVER_ERROR,
            exception,
            request
        )
    }

    private fun buildUserErrorDTO(
        status: HttpStatus,
        exception: Exception,
        request: HttpServletRequest
    ): UserErrorDTO{
        return UserErrorDTO(
            status = status.value(),
            error = status.name,
            message = exception.message,
            path =request.servletPath
        )
    }

    private fun buildUserErrorDTO(
        errorMessage: HashMap<String, String?>,
        request: HttpServletRequest
    ): UserErrorDTO{
        return UserErrorDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path =request.servletPath
        )
    }
}