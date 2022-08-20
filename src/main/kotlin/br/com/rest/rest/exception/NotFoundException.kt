package br.com.rest.rest.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message)