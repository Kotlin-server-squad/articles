package com.kss.articles.article003.coroutines.firstmeet.thread

import com.kss.articles.article003.coroutines.firstmeet.domain.Order
import com.kss.articles.article003.coroutines.firstmeet.thread.restaurant.KitchenThreadServiceImpl

class KitchenThreadMain

fun main() {
    val kitchenService = KitchenThreadServiceImpl()
    val order = Order("1", Order.Meal.BURGER)
    kitchenService.prepareOrder(order)
}