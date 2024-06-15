package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.*

class FlowDemo {}

suspend fun main() {
    val flowServiceDemo = FlowServiceDemo()

    val fl = flowServiceDemo.flowdemo()

    withContext(CoroutineName("Name")){
        val job = launch {
            fl.collect() { println(it) }
        }
        launch {
            delay(2100)
            println("I got enough")
            job.cancel()
        }
    }
}