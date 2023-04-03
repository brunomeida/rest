package br.com.rest.rest.controller

import br.com.rest.rest.model.Acoes
import br.com.rest.rest.service.AcoesService
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileReader
import java.math.BigDecimal

private const val HOME_BRUNO_MENESCAL_CONTABILIZEI_COM_BR_DOWNLOADS_DADOS_CSV = "/home/bruno.menescal@CONTABILIZEI.COM.BR/Downloads/dados.csv"

@RestController
@RequestMapping("/status-invest")
@ResponseBody
class StatusInvestCsvController(val acoesService: AcoesService) {

    @GetMapping
    fun main(): MutableList<Acoes> {
        val file = File(HOME_BRUNO_MENESCAL_CONTABILIZEI_COM_BR_DOWNLOADS_DADOS_CSV)
        val reader = FileReader(file)
        val csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        val stocks = mutableListOf<Acoes>()
        for (record in csvRecords) {
            val ticker = record["TICKER"] ?: continue
            val preco = record["PREÇO"]?.toDoubleOrNull() ?: continue
            val pl = record["P/L"]?.toDoubleOrNull() ?: continue
            val dy = record["DY"]?.toDoubleOrNull() ?: continue
            val pvp = record["P/VP"]?.toDoubleOrNull() ?: continue
            val pebit = record["P/EBIT"]?.toDoubleOrNull() ?: continue
            val pativos = record["P/ATIVOS"]?.toDoubleOrNull() ?: continue
            val evebit = record["EV/EBIT"]?.toDoubleOrNull() ?: continue
            val margemBruta = record["MARGEM BRUTA"]?.toDoubleOrNull() ?: continue
            val margemEbit = record["MARGEM EBIT"]?.toDoubleOrNull() ?: continue
            val margemLiquida = record["MARG. LÍQUIDA"]?.toDoubleOrNull() ?: continue
            val psr = record["PSR"]?.toDoubleOrNull() ?: continue
            val pcapGiro = record["P/CAP. GIRO"]?.toDoubleOrNull() ?: continue
            val precoSobreAtivoCirculanteLiquido = record["PREÇO SOBRE ATIVO CIRC. LÍQ."]?.toDoubleOrNull() ?: continue
            val giroAtivos = record["GIRO ATIVOS"]?.toDoubleOrNull() ?: continue
            val roe = record["ROE"]?.toDoubleOrNull() ?: continue
            val roa = record["ROA"]?.toDoubleOrNull() ?: continue
            val roic = record["ROIC"]?.toDoubleOrNull() ?: continue
            val dividaLiquidaPatrimonio = record["DÍVIDA LÍQUIDA / PATRIMÔNIO"]?.toDoubleOrNull() ?: continue
            val dividaLiquidaEbit = record["DÍVIDA LÍQUIDA / EBIT"]?.toDoubleOrNull() ?: continue
            val patrimonioAtivos = record["PATRIMÔNIO / ATIVOS"]?.toDoubleOrNull() ?: continue
            val passivosAtivos = record["PASSIVOS / ATIVOS"]?.toDoubleOrNull() ?: continue
            val liquidezCorrente = record["LIQUIDEZ CORRENTE"]?.toDoubleOrNull() ?: continue
            val pegRatio = record["PEG RATIO"]?.toDoubleOrNull() ?: continue
            val cagrReceitas5Anos = record["CAGR RECEITAS 5 ANOS"]?.toDoubleOrNull() ?: continue
            val cagrLucros5Anos = record["CAGR LUCROS 5 ANOS"]?.toDoubleOrNull() ?: continue
            val liquidezMediaDiaria = record["LIQUIDEZ MÉDIA DIÁRIA"]?.toDoubleOrNull() ?: continue
            val vpa = record["VPA"]?.toDoubleOrNull() ?: continue
            val lpa = record["LPA"]?.toDoubleOrNull() ?: continue
            val valorMercado = record["VALOR DE MERCADO"] ?: continue

            //val stock = Acoes(ticker, preco, )
            //stocks.add(stock)
        }
        reader.close()
        acoesService.create(stocks)

        return stocks
    }

    private fun getValue(value: String, record: CSVRecord) =
        record.get(value)?.takeIf { it.isNotBlank() }?.toBigDecimal()?.setScale(2) ?: BigDecimal.ZERO

}