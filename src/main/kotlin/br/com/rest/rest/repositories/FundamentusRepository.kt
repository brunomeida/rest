package br.com.rest.rest.repositories

import br.com.rest.rest.model.Fundamentus
import org.springframework.data.jpa.repository.JpaRepository

interface FundamentusRepository: JpaRepository<Fundamentus, Long>{}