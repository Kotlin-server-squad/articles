package com.kss.articles.service

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import org.springframework.stereotype.Service

interface CustomerService {
    fun saveCustomer(customerDto: CustomerDto): CustomerDto
}