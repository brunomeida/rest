package br.com.rest.rest.service

import br.com.rest.rest.model.Fundamentus

interface FundamentusService {
    fun create(fundamentusList: List<Fundamentus>)
}