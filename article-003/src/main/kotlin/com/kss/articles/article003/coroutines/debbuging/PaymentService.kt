package com.kss.articles.article003.coroutines.debbuging

import com.kss.articles.article003.coroutines.debbuging.domain.Order
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

class PaymentService {

    suspend fun processPayment(order: Order) = coroutineScope{
       launch {
           delay(300)
              logger.info("Processing payment for order ${order.id}")
       }
    }

    companion object{
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}