package br.com.rest.rest.repositories

import br.com.rest.rest.model.Login
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Login, Long>{}