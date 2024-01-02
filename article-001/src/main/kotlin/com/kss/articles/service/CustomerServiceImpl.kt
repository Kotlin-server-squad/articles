package com.kss.articles.service

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.mapper.toDto
import com.kss.articles.mapper.toEntity
import com.kss.articles.repository.CustomerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository,
    private val logger: Logger,
): CustomerService {
    override fun saveCustomer(customerDto: CustomerDto): Customer {
       return customerRepository.saveCustomer(customerDto)
    }
}