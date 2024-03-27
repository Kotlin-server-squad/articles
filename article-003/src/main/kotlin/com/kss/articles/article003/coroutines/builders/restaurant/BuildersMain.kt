package com.kss.articles.article003.coroutines.builders.restaurant

import com.kss.articles.article003.coroutines.builders.restaurant.BuildersMain.Companion.logger
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Meal
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Order
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Table
import com.kss.articles.article003.coroutines.builders.restaurant.service.impl.DinningServiceImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

class BuildersMain {
    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}

fun main() {
    val dinningService = DinningServiceImpl()
    val table1 = Table(1, 3,listOf(Order(1,Meal.PASTA), Order(2,Meal.SALAD), Order(3,Meal.SOUP)))
    val table2 = Table(2, 2,listOf(Order(1,Meal.BURGER), Order(2,Meal.SALAD)))
    val tabl3 = Table(3, 4,listOf(Order(1,Meal.PASTA), Order(2,Meal.BURGER), Order(3,Meal.SOUP), Order(4,Meal.SALAD)))

    val tables = listOf(table1, table2, tabl3)
    tables.forEach {
        GlobalScope.launch {
            logger.info("Processing diner at table ${it.id}")
            dinningService.processDiner(it)
            dinningService.sendTip(it, 10.toBigDecimal())
        }
    }
    Thread.sleep(3000)
}