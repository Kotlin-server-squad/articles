package com.kss.articles.article003.coroutines.builders.general.service

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import service.BankService
import java.math.BigDecimal

// Service that aggregates balances from multiple bank accounts
class AccountAggregatorService(
    private val bankServices: List<BankService>
) {
    suspend fun getTotalBalanceV1(userId: String): BigDecimal = coroutineScope {
        bankServices.map { bankService ->
            async {
                bankService.getAccountBalance("Bank ${bankServices.indexOf(bankService) + 1}", userId)
            }.await()
        }
            .map { it.balance }
            .fold(BigDecimal.ZERO) { total, balance -> total + balance }
    }

    suspend fun getTotalBalanceV2(userId: String): BigDecimal = coroutineScope {
        bankServices.map { bankService ->
            async { bankService.getAccountBalance("Bank ${bankServices.indexOf(bankService) + 1}", userId) }
        }.awaitAll()
            .map { it.balance }
            .fold(BigDecimal.ZERO) { total, balance -> total + balance }
    }
}