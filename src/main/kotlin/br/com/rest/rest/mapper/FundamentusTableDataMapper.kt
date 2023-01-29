package br.com.rest.rest.mapper

import br.com.rest.rest.controller.FundamentusTableData
import br.com.rest.rest.mapper.extensions.parseToBigDecimal
import br.com.rest.rest.model.Fundamentus
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class FundamentusTableDataMapper: Mapper<List<FundamentusTableData>, List<Fundamentus>> {
    override fun map(t: List<FundamentusTableData>): List<Fundamentus> {
        val fundamentusList = ArrayList<Fundamentus>()
        t.stream().forEach {
            fundamentusList.add(mapRow(it))
        }

        return fundamentusList

    }

    private fun mapRow(tableRowData: FundamentusTableData?): Fundamentus {
        return Fundamentus(
            papel = tableRowData?.paper ?: "SEM NOME",
            cotacao = tableRowData?.quotation?.parseToBigDecimal() ?: BigDecimal.ZERO,
            pl = tableRowData?.pL?.parseToBigDecimal() ?: BigDecimal.ZERO,
            pvp = tableRowData?.pVp?.parseToBigDecimal() ?: BigDecimal.ZERO,
            psr = tableRowData?.psr?.parseToBigDecimal() ?: BigDecimal.ZERO,
            divYield = fromPercentage(tableRowData?.divYield),
            pAtivo = tableRowData?.pAtivo?.parseToBigDecimal() ?: BigDecimal.ZERO,
            pCapGiro = tableRowData?.pCapGiro?.parseToBigDecimal() ?: BigDecimal.ZERO,
            pEbit = tableRowData?.pEbit?.parseToBigDecimal() ?: BigDecimal.ZERO,
            pAtivCircLiq = tableRowData?.pAtivCircLiq?.parseToBigDecimal() ?: BigDecimal.ZERO,
            evEbit = tableRowData?.evEbit?.parseToBigDecimal() ?: BigDecimal.ZERO,
            evEbitda = tableRowData?.evEbitda?.parseToBigDecimal() ?: BigDecimal.ZERO,
            mrgEbit = fromPercentage(tableRowData?.mrgEbit),
            margemLiquida = fromPercentage(tableRowData?.mrgLiq),
            liquidezCorrente = tableRowData?.liqCorr?.parseToBigDecimal() ?: BigDecimal.ZERO,
            roic = fromPercentage(tableRowData?.roic),
            roe = fromPercentage(tableRowData?.roe),
            liqDoisMeses = tableRowData?.liq2Meses?.parseToBigDecimal() ?: BigDecimal.ZERO,
            patrimonioLiq = tableRowData?.patrimonioLiq?.parseToBigDecimal() ?: BigDecimal.ZERO,
            divBrutPatri = tableRowData?.divBrutPatri?.parseToBigDecimal() ?: BigDecimal.ZERO,
            crescRecCincoAnos = fromPercentage(tableRowData?.crescRec5A),
        )
    }

    private fun fromPercentage(value: String?): BigDecimal {
        if (value == null || value == "") {
            return BigDecimal.ZERO
        }
        val valueField = BigDecimal(
            value
                .replace(".", "").replace(",", ".")
                .removeSuffix("%")
        )
        return valueField.divide(BigDecimal(100))
    }

}
