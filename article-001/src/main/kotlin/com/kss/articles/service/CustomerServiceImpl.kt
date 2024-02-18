package com.kss.articles.service

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.mapper.toDto
import com.kss.articles.repository.CustomerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository,
    private val logger: Logger,
): CustomerService {
    override fun saveCustomer(customerDto: CustomerDto): CustomerDto {
       return customerRepository.saveCustomer(customerDto).toDto().also {
           logger.info("Customer $it")
           }
    }

    override fun getAllValidCustomers(): List<Customer> {
        return customerRepository.getAllCustomers()
    }

    override fun getAllCustomersWhichAgeIsEven(): List<Customer> {
        return customerRepository.getCustomersByAgeIsEven()
    }

    override fun getCustomerSecondOrNull(): Customer? {
        return customerRepository.getSecondOrNullCustomer()
    }
}