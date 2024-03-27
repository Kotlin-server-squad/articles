package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.domain

data class CustomerDetail(
    val id: String,
    val username: String,
    val email: String,
    val job: Job,
    val address: Address,
    ){
    data class Job(
        val id: String,
        val title: String,
        val description: String,
    )
    data class Address(
        val id: String,
        val street: String,
        val city: String,
        val country: String,
    )
}
