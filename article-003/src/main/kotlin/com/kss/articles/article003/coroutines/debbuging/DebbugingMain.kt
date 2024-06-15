package com.kss.articles.article003.coroutines.debbuging

import com.kss.articles.article003.coroutines.debbuging.domain.Order
import kotlinx.coroutines.runBlocking

class DebbugingMain {}

fun main() = runBlocking {
    val orderService = OrderService()
    val orders = listOf(
        Order(id = "ornare", item = "autem", quantity = 4848, price = 2.3),
        Order(id = "assueverit", item = "etiam", quantity = 4236, price = 6.7),
        Order(id = "assueverit", item = "etiam", quantity = 4236, price = 6.7)
    )
    orderService.processOrders(orders)
}