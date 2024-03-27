package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.impl

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.AddressResponse
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.AddressService
import kotlinx.coroutines.delay
import java.util.*

class AddressServiceImpl : AddressService {
    override suspend fun getAddress(customerId: String): AddressResponse {
        // Simulate a I/O operation call remote service
        delay(750)
        return AddressResponse(
            id = UUID.randomUUID().toString(), street = "1234 Main St", city = "Anytown", country = "AS",
        )
    }
}