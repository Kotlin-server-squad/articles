package com.kss.articles.repository.impl

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.mapper.toEntity
import com.kss.articles.repository.CustomerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class CustomerRepositoryImpl(
    private val logger: Logger,
): CustomerRepository {
    override fun saveCustomer(customerDto: CustomerDto): Customer {
        //map to entity
        val customer = customerDto.toEntity()
        //for testing purpose log and return
        logger.info("Customer $customer")
        return customer
    }
}