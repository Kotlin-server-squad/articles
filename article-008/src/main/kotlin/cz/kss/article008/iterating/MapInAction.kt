package cz.kss.article008.iterating

import java.util.*

class MapInAction

data class Order(val id: UUID, val amount: Double, val currency: String)

fun generateOrders(): List<Order> {
    val orders = listOf(
        Order(UUID.randomUUID(), 100.0, "EUR"),
        Order(UUID.randomUUID(), 200.0, "USD"),
        Order(UUID.randomUUID(), 300.0, "GBP"),
        Order(UUID.randomUUID(), 400.0, "EUR"),
        Order(UUID.randomUUID(), 500.0, "USD"),
        Order(UUID.randomUUID(), 600.0, "GBP"),
    )
    return orders
}

fun main() {
    val orders = generateOrders()
    val ordersMap = orders.groupBy { it.id }
    for ((key, value) in ordersMap) {
        println("$key = $value")
    }

    for ((index, element) in orders.withIndex()) {
        println("$index = $element")
    }
}