package br.com.rest.rest.controller

import okhttp3.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

class TableRowData(val paper: String?, val quotation: String, val p_l: String, val p_vp: String, val psr: String, val div_yield: String, val p_ativo: String, val p_cap_giro: String, val p_ebit: String, val p_ativ_circ_liq: String, val ev_ebit: String, val ev_ebitda: String, val mrg_ebit: String, val mrg_liq: String, val liq_corr: String)

@RestController
@RequestMapping("/hello")
@ResponseBody
class RestController {
    @GetMapping
    fun hello():List<TableRowData>? {
        val url = "https://www.fundamentus.com.br/resultado.php"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36")
            .build()
        val response = client.newCall(request).execute()
        val body = response.body?.string()
        val json = TableParser().parse(body)
        return json
    }
}

class TableParser {
    fun parse(html: String?): List<TableRowData> {
        val doc: Document = Jsoup.parse(html)
        val table = doc.getElementById("resultado")
        val rows = table.getElementsByTag("tr")
        val data = mutableListOf<TableRowData>()
        for (row in rows) {
            val columns = row.getElementsByTag("td")
            if (!columns.isEmpty()){
                val paper = columns[0]?.text()
                val quotation = columns[1].text()
                val p_l = columns[2].text()
                val p_vp = columns[3].text()
                val psr = columns[4].text()
                val div_yield = columns[5].text()
                val p_ativo = columns[6].text()
                val p_cap_giro = columns[7].text()
                val p_ebit = columns[8].text()
                val p_ativ_circ_liq = columns[9].text()
                val ev_ebit = columns[10].text()
                val ev_ebitda = columns[11].text()
                val mrg_ebit = columns[12].text()
                val mrg_liq = columns[13].text()
                val liq_corr = columns[14].text()
                val record = TableRowData(paper, quotation, p_l, p_vp, psr, div_yield, p_ativo, p_cap_giro, p_ebit, p_ativ_circ_liq, ev_ebit, ev_ebitda, mrg_ebit, mrg_liq, liq_corr)
                data.add(record)
            }
        }
        return data
    }
}



