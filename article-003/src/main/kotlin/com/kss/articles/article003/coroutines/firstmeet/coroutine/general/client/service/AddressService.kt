package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.AddressResponse

interface AddressService {
    suspend fun getAddress(customerId: String): AddressResponse
}