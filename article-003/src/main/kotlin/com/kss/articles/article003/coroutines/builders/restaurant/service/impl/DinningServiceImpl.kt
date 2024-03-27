package com.kss.articles.article003.coroutines.builders.restaurant.service.impl

import com.kss.articles.article003.coroutines.builders.restaurant.domain.Meal
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Table
import com.kss.articles.article003.coroutines.builders.restaurant.service.DinningService
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.math.BigDecimal

class DinningServiceImpl: DinningService {
    private val kitchenService = KitchenServiceImpl()
    override suspend fun processDiner(table: Table): List<Meal> = coroutineScope{
        table.orders.map { async { kitchenService.prepareOrder(it) } }.awaitAll()

    }

    override suspend fun sendTip(table: Table, tip: BigDecimal): Unit = coroutineScope{
        launch {
            println("Sending tip of $tip to the kitchen staff")
        }
    }
}