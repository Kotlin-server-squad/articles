package com.kss.articles.article003.coroutines.flow.flow2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MakeFlow{}

suspend fun main() = coroutineScope {
    val flow = makeFlow()
    println("Calling flow...")
    flow.collect { println(it) }
    println("Consuming flow again...")
    flow.collect { println(it) }
}

private fun makeFlow() = flow{
    println("Flow started")
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}