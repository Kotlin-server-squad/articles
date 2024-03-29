package com.kss.articles.dto

data class CustomerDto(
    val id: Long? = null,
    val userName: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val address: AddressDto,
    val age: Int
)
