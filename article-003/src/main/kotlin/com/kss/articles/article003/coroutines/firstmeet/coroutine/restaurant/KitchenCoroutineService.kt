package com.kss.articles.article003.coroutines.firstmeet.coroutine.restaurant

import com.kss.articles.article003.coroutines.firstmeet.domain.Order

interface KitchenCoroutineService {
    suspend fun prepareOrder(order: Order)
}