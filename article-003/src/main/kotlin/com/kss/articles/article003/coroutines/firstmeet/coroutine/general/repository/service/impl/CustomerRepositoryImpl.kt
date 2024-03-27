package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.service.impl

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.Customer
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.service.CustomerRepository
import kotlinx.coroutines.delay
import java.util.UUID

class CustomerRepositoryImpl: CustomerRepository {
    override suspend fun getCustomer(customerId: String): Customer {
        // Simulate a I/O operation call db
        delay(500)
        return Customer(id = UUID.randomUUID().toString(), username = "jiridoe", email = "jiridoe@email.com")
    }
}