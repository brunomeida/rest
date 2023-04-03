package br.com.rest.rest.mapper.extensions

import br.com.rest.rest.controller.FundamentusTableData
import br.com.rest.rest.mapper.FundamentusTableDataMapper

private val fundamentusTableDataMapper = FundamentusTableDataMapper()

fun List<FundamentusTableData>.toModelList() = fundamentusTableDataMapper.map(this)