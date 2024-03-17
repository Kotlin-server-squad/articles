package com.kss.articles.article003.coroutines.firstmeet.domain

data class Order(
    val id: String,
    val meal: Meal
){
    enum class Meal{
        PASTA,
        SALAD,
        SOUP,
        BURGER
    }
}
