package com.kss.articles.article003.coroutines.builders.restaurant.service

import com.kss.articles.article003.coroutines.builders.restaurant.domain.Meal
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Table
import java.math.BigDecimal

interface DinningService {
    suspend fun processDiner(table: Table): List<Meal>
    suspend fun sendTip(table: Table, tip: BigDecimal)
}