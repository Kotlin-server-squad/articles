package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class FlowServiceDemo {
    fun flowdemo() = flow{
        repeat(5) {
            delay(1000)
            val ctx = currentCoroutineContext()
            val name = ctx[CoroutineName]?.name
            emit("Item$it $name")
        }
    }
}