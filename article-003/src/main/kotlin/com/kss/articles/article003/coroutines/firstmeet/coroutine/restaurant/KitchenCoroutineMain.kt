package com.kss.articles.article003.coroutines.firstmeet.coroutine.restaurant

import com.kss.articles.article003.coroutines.firstmeet.coroutine.restaurant.service.KitchenCoroutineServiceImpl
import com.kss.articles.article003.coroutines.firstmeet.domain.Order
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class KitchenCoroutineMain
fun main() {
    GlobalScope.launch {
        val kitchenService = KitchenCoroutineServiceImpl()
        val order = Order("1", Order.Meal.BURGER)
        kitchenService.prepareOrder(order)
    }
    Thread.sleep(4000)
}