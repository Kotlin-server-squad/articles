package com.kss.articles.domain

data class Address(
    val id: Long? = null,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: Int,
)
