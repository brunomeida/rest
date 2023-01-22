package br.com.rest.rest.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Acoes (
    @Id
    val TICKER: String,
    val PRECO: BigDecimal?,
    val DY: BigDecimal?,
    val PL: BigDecimal?,
    val PV: BigDecimal?,
    val LPA: BigDecimal?,
    val PATIVOS: BigDecimal?,
    val PEBIT: BigDecimal?,
    val EVEBIT: BigDecimal?,
    val DIVLIQPATRI: BigDecimal?,
    val PSR: BigDecimal?,
    val ROE: BigDecimal?,
    val ROA: BigDecimal?,
    val ROIC: BigDecimal?,
    val LIQUIDMEDDIARIA: BigDecimal?,
    val VPA: BigDecimal?,
    val PEGRATIO: BigDecimal?,
    val VALORMERCADO: BigDecimal?
)
