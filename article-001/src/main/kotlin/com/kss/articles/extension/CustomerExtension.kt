package com.kss.articles.extension

import com.kss.articles.domain.Customer

fun Customer.isEmailValid(): Boolean {
    return email.contains("@") && email.contains(".")
}
fun Customer.isValid(): Boolean {
    return id != null && isEmailValid() // Add more conditions as needed
}