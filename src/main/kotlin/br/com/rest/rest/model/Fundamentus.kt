package br.com.rest.rest.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "fundamentus")
data class Fundamentus (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    val id: Long? = null,
    val papel: String?,
    val cotacao: BigDecimal,
    val pl: BigDecimal,
    val pvp: BigDecimal,
    val psr: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val divYield: BigDecimal,
    val pAtivo: BigDecimal,
    val pCapGiro: BigDecimal,
    val pEbit: BigDecimal,
    val pAtivCircLiq: BigDecimal,
    val evEbit: BigDecimal,
    val evEbitda: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val mrgEbit: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val margemLiquida: BigDecimal,
    val liquidezCorrente: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val roic: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val roe: BigDecimal,
    val liqDoisMeses: BigDecimal,
    val patrimonioLiq: BigDecimal,
    val divBrutPatri: BigDecimal,
    @Column(columnDefinition = "COMMENT '%'")
    val crescRecCincoAnos: BigDecimal
)
