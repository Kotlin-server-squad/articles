package com.kss.articles.controller

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.service.CustomerService
import org.springframework.stereotype.Controller

@Controller
class CustomerController(
    private val customerService: CustomerService,
) {
    @PostMapping("/customer")
    fun saveCustomer(@RequestBody customerDto: CustomerDto): Customer {
        return customerService.saveCustomer(customerDto)
    }
}