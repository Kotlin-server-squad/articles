package com.kss.articles.domain

data class Customer(
    val id: Long?= null,
    val firstName: String,
    val lastName: String,
    val userName: String,
    val email: String,
    val age: Int,
    val address: Address,
)
