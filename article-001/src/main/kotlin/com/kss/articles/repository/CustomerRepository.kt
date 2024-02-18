package com.kss.articles.repository

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto

interface CustomerRepository {
    fun saveCustomer(customerDto: CustomerDto): Customer
    fun getAllCustomers(): List<Customer>
    fun getCustomersByAgeIsEven(): List<Customer>
    fun getSecondOrNullCustomer(): Customer?
}