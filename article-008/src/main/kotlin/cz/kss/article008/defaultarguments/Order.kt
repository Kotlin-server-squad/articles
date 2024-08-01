package cz.kss.article008.defaultarguments

import java.util.*

    data class Order(
        val id: UUID,
        val amount: Double,
        val currency: String,
        val itemId: UUID,
        val quantity: Int = 1,
        val discount: Double?,
        val shipping: Double,
        val tax: Double?
    )
