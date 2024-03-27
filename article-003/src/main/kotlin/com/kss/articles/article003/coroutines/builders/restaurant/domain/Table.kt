package com.kss.articles.article003.coroutines.builders.restaurant.domain

data class Table(
    val id: Long,
    val seats: Int,
    val orders: List<Order>
)
