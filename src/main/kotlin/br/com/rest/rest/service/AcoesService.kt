package br.com.rest.rest.service

import br.com.rest.rest.model.Acoes

interface AcoesService {
    fun create(acoes: List<Acoes>)
}