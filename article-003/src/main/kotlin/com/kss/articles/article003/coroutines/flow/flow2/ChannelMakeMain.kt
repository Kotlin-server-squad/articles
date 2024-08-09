package com.kss.articles.article003.coroutines.flow.flow2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class ChannelMakeMain{}

suspend fun main() = coroutineScope {
    val channel = makeChannel()
    delay(1000)
    println("Calling  channel...")
    for (i in channel) {
        println("Received: $i")
    }
    println("Consuming channel...")
    for (i in channel) {
        println("Received: $i")
    }
}

private fun CoroutineScope.makeChannel() = produce{
    println("Channel started")
    for (i in 1..5) {
        delay(1000)
        send(i)
    }
}