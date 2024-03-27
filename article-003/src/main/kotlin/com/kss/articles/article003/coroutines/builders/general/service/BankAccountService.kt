package service

import com.kss.articles.article003.coroutines.builders.general.domain.BankAccount
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import util.RandomDelayService.getRandomDelay
import java.math.BigDecimal

// Simulates a bank service that returns the balance of a user's account
class BankService {
    // Simulate API call to get account balance from a bank
    suspend fun getAccountBalance(bankName: String, userId: String): BankAccount {
        delay(getRandomDelay())
        logger.info("Get account balance for bank $bankName and user $userId")
        return BankAccount(bankName, BigDecimal((100..10000).random()))
    }

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}