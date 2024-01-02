package com.kss.articles.mapper

import com.kss.articles.domain.Address
import com.kss.articles.domain.Customer
import com.kss.articles.dto.AddressDto
import com.kss.articles.dto.CustomerDto

fun CustomerDto.toEntity(): Customer {
    return Customer(
        id = 0,
        firstName = "",
        lastName = "",
        userName = "",
        email = "",
        address = Address(id = 0, street = "", city = "", state = "", zipCode = 0)

    )
}

fun Customer.toDto(): CustomerDto {
    return CustomerDto(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        userName = this.userName.reverseAndUppercase(),
        email = this.email,
        address = this.address.toDto()
    )
}

fun Address.toDto(): AddressDto {
    return AddressDto(
        street = this.street,
        city = this.city,
        state = this.state,
        zipCode = this.zipCode
    )
}

fun AddressDto.toEntity(): Address {
    return Address(
        street = this.street,
        city = this.city,
        state = this.state,
        zipCode = this.zipCode,
    )
}
