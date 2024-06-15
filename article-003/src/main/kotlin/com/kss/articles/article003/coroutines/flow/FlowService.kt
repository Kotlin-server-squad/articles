package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowService {
    fun getFlow(): Flow<String> = flow{
        repeat(3){
            delay(300)
            emit("Item$it")
        }
    }
}