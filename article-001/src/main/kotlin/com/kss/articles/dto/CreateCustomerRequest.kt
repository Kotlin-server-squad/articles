package com.kss.articles.dto

data class CreateCustomerRequest(
    val userName: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val address: CreateAddresRequest,
)
