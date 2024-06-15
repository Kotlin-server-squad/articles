package com.kss.articles.article003.coroutines.debbuging

import com.kss.articles.article003.coroutines.debbuging.domain.Order
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import kotlin.random.Random

class NotificationService {
    private val handler = CoroutineExceptionHandler { _, exception ->
        logger.error("Caught $exception")
    }
    private val scope = CoroutineScope(Dispatchers.Default)

    suspend fun notifyCustomer(order: Order) = coroutineScope {
        launch {
            delay(200)
            val random = Random.nextInt(1,5)
//            if(random > 3 ) {
                throw RuntimeException("Error sending notification")
//            }
        }
    }

    companion object{
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}