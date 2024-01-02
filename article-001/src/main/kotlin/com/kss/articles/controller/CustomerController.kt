package com.kss.articles.controller

import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.mapper.toDto
import com.kss.articles.service.CustomerService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController(
    private val customerService: CustomerService,
) {
    @PostMapping()
    fun saveCustomer(@RequestBody customerDto: CustomerDto): CustomerDto {
        return customerService.saveCustomer(customerDto)
    }
}