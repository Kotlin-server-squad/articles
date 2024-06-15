package com.kss.articles.article003.coroutines.flow.understanding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Main2 {}

suspend fun main() {
    val f: suspend ((String) -> Unit) -> Unit = { emit ->
        emit("A")
        emit("B")
        emit("C")
    }

    f{ println(it)}
    f{ println(it)}
}