package com.kss.articles.service

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto

interface CustomerService {
    fun saveCustomer(customerDto: CustomerDto): CustomerDto
    fun getAllValidCustomers(): List<Customer>
    fun getAllCustomersWhichAgeIsEven(): List<Customer>
    fun getCustomerSecondOrNull(): Customer?
}