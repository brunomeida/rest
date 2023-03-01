package br.com.rest.rest.controller

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/b3")
@ResponseBody
class FinancialDataController {
    @GetMapping
    fun main() {
        val ticker = "BBAS3"
        val privKey = ""
        val url = "https://api.iex.cloud/v1/data/core/quote/aapl?token=$privKey"

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        val jsonData = response.body?.string()
        val json = JSONObject(jsonData)

        // Parse JSON to extract financial data
        val revenue = json.getJSONObject("financials").getDouble("totalRevenue")
        val netIncome = json.getJSONObject("financials").getDouble("netIncome")
        val debt = json.getJSONObject("balanceSheet").getDouble("totalDebt")
        val cash = json.getJSONObject("balanceSheet").getDouble("cash")
        println("Revenue: $revenue")
        println("Net Income: $netIncome")
        println("Total Debt: $debt")
        println("Cash: $cash")
    }
}