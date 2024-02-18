package com.kss.articles.extension

import com.kss.articles.domain.Customer

fun String.reverseAndUppercase(): String {
    return this.reversed().uppercase()
}

fun Int.isEven(): Boolean = this % 2 == 0

fun <T> List<T>.secondOrNull(): T? = if (this.size >= 2) this[1] else null
