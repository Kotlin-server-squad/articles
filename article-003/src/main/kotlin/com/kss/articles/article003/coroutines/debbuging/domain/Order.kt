package com.kss.articles.article003.coroutines.debbuging.domain

data class Order(
    val id: String,
    val item: String,
    val quantity: Int,
    val price: Double,
)
