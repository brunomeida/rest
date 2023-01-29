package br.com.rest.rest.controller

import br.com.rest.rest.mapper.extensions.toModelList
import br.com.rest.rest.service.FundamentusService
import okhttp3.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

class FundamentusTableData(
    val paper: String?,
    val quotation: String,
    val pL: String,
    val pVp: String,
    val psr: String,
    val divYield: String,
    val pAtivo: String,
    val pCapGiro: String,
    val pEbit: String,
    val pAtivCircLiq: String,
    val evEbit: String,
    val evEbitda: String,
    val mrgEbit: String,
    val mrgLiq: String,
    val liqCorr: String,
    val roic: String,
    val roe: String,
    val liq2Meses: String,
    val patrimonioLiq: String,
    val divBrutPatri: String,
    val crescRec5A: String
)

@RestController
@RequestMapping("/hello")
@ResponseBody
class RestController(private val fundamentusService: FundamentusService) {
    @GetMapping
    fun hello():List<FundamentusTableData>? {
        val url = "https://www.fundamentus.com.br/resultado.php"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36")
            .build()
        val response = client.newCall(request).execute()
        val body = response.body?.string()
        val data = TableParser().parse(body)
        try {
            fundamentusService.create(data.toModelList())
        }catch (e: Exception){
            throw RuntimeException("Deu bosta. ${e.message}", e)
        }
        return data
    }
}

class TableParser {
    fun parse(html: String?): List<FundamentusTableData> {
        val doc: Document = Jsoup.parse(html)
        val table = doc.getElementById("resultado")
        val rows = table.getElementsByTag("tr")
        val data = mutableListOf<FundamentusTableData>()
        for (row in rows) {
            val columns = row.getElementsByTag("td")
            if (!columns.isEmpty()){
                val paper = columns[0]?.text()
                val quotation = columns[1].text()
                val pL = columns[2].text()
                val pVp = columns[3].text()
                val psr = columns[4].text()
                val divYield = columns[5].text()
                val pAtivo = columns[6].text()
                val pCapGiro = columns[7].text()
                val pEbit = columns[8].text()
                val pAtivCircLiq = columns[9].text()
                val evEbit = columns[10].text()
                val evEbitda = columns[11].text()
                val mrgEbit = columns[12].text()
                val mrgLiq = columns[13].text()
                val liqCorr = columns[14].text()
                val roic = columns[15].text()
                val roe = columns[16].text()
                val liq2Meses = columns[17].text()
                val patrimonioLiq = columns[18].text()
                val divBrutPatri = columns[19].text()
                val crescRec5A = columns[19].text()

                val record = FundamentusTableData(
                    paper,
                    quotation,
                    pL,
                    pVp,
                    psr,
                    divYield,
                    pAtivo,
                    pCapGiro,
                    pEbit,
                    pAtivCircLiq,
                    evEbit,
                    evEbitda,
                    mrgEbit,
                    mrgLiq,
                    liqCorr,
                    roic,
                    roe,
                    liq2Meses,
                    patrimonioLiq,
                    divBrutPatri,
                    crescRec5A)
                data.add(record)
            }
        }
        return data
    }
}



