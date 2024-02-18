package com.kss.articles.repository.impl

import com.kss.articles.domain.Address
import com.kss.articles.domain.Customer
import com.kss.articles.dto.CustomerDto
import com.kss.articles.extension.isValid
import com.kss.articles.extension.isEven
import com.kss.articles.extension.secondOrNull
import com.kss.articles.mapper.toEntity
import com.kss.articles.repository.CustomerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CustomerRepositoryImpl(
    private val logger: Logger,
): CustomerRepository {
    override fun saveCustomer(customerDto: CustomerDto): Customer {
        //map to entity
        val customer = customerDto.toEntity()
        if(customer.isValid()) {
            //for testing purpose log and return
            logger.info("Customer $customer")
            return customer
        }else{
            throw error("Invalid Email")
        }
    }

    override fun getAllCustomers(): List<Customer> {
        return generateCustomers().filter { it.isValid() }
    }

    override fun getCustomersByAgeIsEven(): List<Customer> {
        return generateCustomers().filter { customer -> customer.age.isEven() }
    }

    override fun getSecondOrNullCustomer(): Customer? {
        return generateCustomers().secondOrNull()
    }

    private fun generateCustomers(): List<Customer> {
        val customers = mutableListOf<Customer>()
        for (i in 1..10){
           customers.add(generateRandomCustomer())
        }
        return customers
    }

    private fun randomString() = (1..STRING_LENGTH)
        .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
        .joinToString("")

    fun generateRandomAddress(): Address {
        val streets = listOf("Main St", "Elm St", "Oak St")
        val cities = listOf("New York", "Los Angeles", "Chicago")
        val states = listOf("NY", "CA", "IL")
        val zipCodes = listOf(10001, 90001, 60007)

        return Address(
            street = streets.random(),
            city = cities.random(),
            state = states.random(),
            zipCode = zipCodes.random()
        )
    }

    fun generateRandomCustomer(): Customer {
        val firstNames = listOf("John", "Jane", "Alex")
        val lastNames = listOf("Doe", "Smith", "Johnson")
        val userNames = listOf("johndoe", "janesmith", "alexjohnson")
        val emails = listOf("john@example.com", "jane@example.com", "alex@example.com")
        val ages = (18..100).toList()

        return Customer(
            id = null,
            firstName = firstNames.random(),
            lastName = lastNames.random(),
            userName = userNames.random(),
            email = emails.random(),
            age = ages.random(),
            address = generateRandomAddress()
        )
    }


    companion object {
        private const val STRING_LENGTH = 10
        private val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
    }
}