package com.kss.articles.article003.coroutines.channel

import com.kss.articles.article003.coroutines.channel.domain.CacheEntryKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class CacheMain

fun main() = runBlocking {
    val cacheManagerService = CacheManagerService()
    val timeInMillis = measureTimeMillis {
        repeat(10) {
            launch { cacheManagerService.send(CacheEntryKey.CUSTOMER) }
            launch { cacheManagerService.send(CacheEntryKey.CUSTOMER) }
            launch { cacheManagerService.send(CacheEntryKey.EVENT) }
            launch { cacheManagerService.send(CacheEntryKey.EVENT) }
        }
    }
    println("Time in milliseconds: $timeInMillis")
    delay(10000)
}