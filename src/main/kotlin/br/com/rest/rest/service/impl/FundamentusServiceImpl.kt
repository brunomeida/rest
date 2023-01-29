package br.com.rest.rest.service.impl

import br.com.rest.rest.model.Fundamentus
import br.com.rest.rest.repositories.FundamentusRepository
import br.com.rest.rest.service.FundamentusService
import org.springframework.stereotype.Service

@Service
class FundamentusServiceImpl(
    private val fundadmentusRepository: FundamentusRepository
): FundamentusService {
    override fun create(fundamentusList: List<Fundamentus>) {
        fundadmentusRepository.saveAll(fundamentusList)
    }
}
