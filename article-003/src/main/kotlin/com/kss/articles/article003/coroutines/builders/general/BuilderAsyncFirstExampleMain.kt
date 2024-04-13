package com.kss.articles.article003.coroutines.builders.general

import com.kss.articles.article003.coroutines.builders.general.service.AccountAggregatorService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import service.FinancialReportingService

class BuilderAsyncFirstExampleMain{}

fun main(){
        GlobalScope.launch {
                val reportService = FinancialReportingService()
                reportService.generateFinancialReport("user1234")
        }
        Thread.sleep(2000)
}