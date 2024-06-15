package com.kss.articles.article003.coroutines.flow.understanding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Main1 {}

fun main() {
    val f: suspend () -> Unit = {
        println("A")
        println("B")
        println("C")
    }
    GlobalScope.launch {
        f()
        f()
    }
    Thread.sleep(1000)
}