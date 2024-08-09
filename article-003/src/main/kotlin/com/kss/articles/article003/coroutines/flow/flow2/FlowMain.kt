package com.kss.articles.article003.coroutines.flow.flow2

import com.kss.articles.article003.coroutines.flow.understanding.flow
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FlowMain {
}

fun main(): Unit = runBlocking{
    val flower = flow {
        while (true){
            val value = computeNexVal()
            delay(1000)
            emit(value)
        }
    }


}

fun computeNexVal(): Int {
    return (0..100).random()
}