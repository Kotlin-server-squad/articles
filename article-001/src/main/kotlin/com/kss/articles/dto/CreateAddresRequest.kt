package com.kss.articles.dto

data class CreateAddresRequest(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: Int,
)
