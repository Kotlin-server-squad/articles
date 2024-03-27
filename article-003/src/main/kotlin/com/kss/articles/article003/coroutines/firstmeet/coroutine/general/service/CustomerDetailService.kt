package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.service

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.domain.CustomerDetail

interface CustomerDetailService {
    suspend fun getCustomerDetail(customerId: String): CustomerDetail
}