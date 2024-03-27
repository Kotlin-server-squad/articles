package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.service

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.Customer

interface CustomerRepository {
    suspend fun getCustomer(customerId: String): Customer
}