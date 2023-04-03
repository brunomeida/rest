package br.com.rest.rest.service.impl

import br.com.rest.rest.model.Acoes
import br.com.rest.rest.repositories.AcoesRepository
import br.com.rest.rest.service.AcoesService
import org.springframework.stereotype.Service

@Service
class AcoesServiceImpl(
    private val userRepository: AcoesRepository
): AcoesService {
    override fun create(acoes: List<Acoes>) {
        val createdUser = userRepository.saveAll(acoes)
    }
}
