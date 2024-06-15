package com.kss.articles.article003.coroutines.flow.understanding

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class Main3 {}
fun interface FlowColector<T> {
    suspend fun emit(value: T)
}

fun interface Flow<T> {
    suspend fun collector(collector: FlowColector<T>)
}

fun <T> flow(
    builder: suspend FlowColector<T>.() -> Unit
) = object : Flow<T> {
    override suspend fun collector(collector: FlowColector<T>) {
        collector.builder()
    }
}

suspend fun main() {
    val f: Flow<String> = flow {
        emit("A")
        emit("B")
        emit("C")
    }
    f.collector { println(it) }
    f.collector { println(it) }
    println("------")
    flowOf("a", "b", "c")
        .map {
            delay(1000)
            it.uppercase()
        }
        .collect() { println(it) }
    println("------")
    flowOf("a", "b", "c")
        .onEach { delay(1000) }
        .collect {
            println(it)
        }
    println("------")
}
