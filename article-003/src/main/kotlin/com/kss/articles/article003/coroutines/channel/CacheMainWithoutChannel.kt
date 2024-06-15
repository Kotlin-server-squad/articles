package com.kss.articles.article003.coroutines.channel

import com.kss.articles.article003.coroutines.channel.domain.CacheEntryKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class CacheMainWithoutChannel{}

fun main() = runBlocking{
    val cacheService = CacheManagerServiceWithoutChannel()
    val timeInMillis = measureTimeMillis {
        repeat(10) {
            launch { cacheService.send(CacheEntryKey.CUSTOMER) }
            launch { cacheService.send(CacheEntryKey.CUSTOMER) }
            launch { cacheService.send(CacheEntryKey.EVENT) }
            launch { cacheService.send(CacheEntryKey.EVENT) }
        }
    }
    delay(10000)
    println("Time in milliseconds: $timeInMillis")


}