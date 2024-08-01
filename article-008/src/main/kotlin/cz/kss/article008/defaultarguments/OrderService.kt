package cz.kss.article008.defaultarguments

import java.util.*

class OrderService {
    fun createOrder(): Order {
        return Order(
            id = UUID.randomUUID(),
            amount = 8.9,
            currency = "maximus",
            itemId = UUID.randomUUID(),
            quantity = 6453,
            discount = null,
            shipping = 10.11, tax = null,
        )
    }
}