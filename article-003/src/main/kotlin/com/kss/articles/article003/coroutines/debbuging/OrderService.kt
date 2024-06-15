package com.kss.articles.article003.coroutines.debbuging

import com.kss.articles.article003.coroutines.debbuging.domain.Order
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

class OrderService {
    private val paymentService = PaymentService()
    private val notificationService = NotificationService()

    suspend fun processOrders(orders: List<Order>) = coroutineScope{
        orders.forEach { order ->
            launch {
                paymentService.processPayment(order)
            }
            launch {
                notificationService.notifyCustomer(order)
            }
        }

        logger.info("Orders has been proccesed")
    }

    companion object{
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}