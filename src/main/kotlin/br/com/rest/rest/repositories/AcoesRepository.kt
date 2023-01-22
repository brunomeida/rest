package br.com.rest.rest.repositories

import br.com.rest.rest.model.Acoes
import org.springframework.data.jpa.repository.JpaRepository

interface AcoesRepository: JpaRepository<Acoes, Long>{}