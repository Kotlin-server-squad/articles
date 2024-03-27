package com.kss.articles.article003.coroutines.builders.restaurant.service

import com.kss.articles.article003.coroutines.builders.restaurant.domain.Meal
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Order


interface KitchenService {
    suspend fun prepareOrder(order: Order): Meal
}