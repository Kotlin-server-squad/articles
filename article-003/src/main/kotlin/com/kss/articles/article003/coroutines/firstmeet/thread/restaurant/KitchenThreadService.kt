package com.kss.articles.article003.coroutines.firstmeet.thread.restaurant

import com.kss.articles.article003.coroutines.firstmeet.domain.Order

interface KitchenThreadService {
    fun prepareOrder(order: Order)
}