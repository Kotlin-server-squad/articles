package com.kss.articles.article003.coroutines.channel.new.example2

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FirstTouchZero

fun main(): Unit = runBlocking{
    println("FirstTouchZero")
    val channel = Channel<String>()
    launch {
        repeat(5){
            channel.send("Hello $it")
            delay(300)
        }
    }

    launch {
        for (i in channel) {
            println(i)
        }
    }
}