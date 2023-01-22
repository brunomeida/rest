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

private const val _HOME_BRUNO_MENESCAL_CONTABILIZEI_COM_BR_DOWNLOADS_DADOS_CSV = "/home/bruno.menescal@CONTABILIZEI.COM.BR/Downloads/dados.csv"

@RestController
@RequestMapping("/csv")
@ResponseBody
class CsvController(val acoesService: AcoesService) {
    @GetMapping
    fun main(): MutableList<Acoes> {
        val file = File(_HOME_BRUNO_MENESCAL_CONTABILIZEI_COM_BR_DOWNLOADS_DADOS_CSV)
        val reader = FileReader(file)
        val csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        val stocks = mutableListOf<Acoes>()
        for (record in csvRecords) {
            val stock = Acoes(
                record.get("TICKER"),
                getValue("PRECO", record),
                getValue("DY", record),
                getValue("P/L", record),
                getValue("P/VP", record),
                getValue("LPA", record),
                getValue("P/ATIVOS", record),
                getValue("P/EBIT", record),
                getValue("EV/EBIT", record),
                getValue("DIV.LIQ./PATRI.", record),
                getValue("PSR", record),
                getValue("ROE", record),
                getValue("ROA", record),
                getValue("ROIC", record),
                getValue("LIQUIDEZMEDIADIARIA", record),
                getValue("VPA", record),
                getValue("PEGRatio", record),
                getValue("VALORDEMERCADO", record)
            )
            stocks.add(stock)
        }
        reader.close()
        acoesService.create(stocks)

        return stocks
    }

    private fun getValue(value: String, record: CSVRecord) =
        record.get(value)?.takeIf { it.isNotBlank() }?.toBigDecimal()?.setScale(2) ?: BigDecimal.ZERO

}