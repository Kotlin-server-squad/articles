package com.kss.articles.article003.coroutines.channel

import com.kss.articles.article003.coroutines.channel.domain.CacheEntryKey
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.slf4j.LoggerFactory

class CacheManagerService {
    private val cacheService = CacheService()
    private val channel = Channel<CacheEntryKey>()

    private val evictWorker = Dispatchers.Default.limitedParallelism(1)

    private val evictScope = CoroutineScope(evictWorker)

    val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            processing()
        }
        evictScope.launch {
            evictCache()
        }
    }

    suspend fun send(key: CacheEntryKey) = coroutineScope {
        launch {
            logger.info("Sending key")
            delay(100)
            channel.send(key)
        }
    }

    suspend fun processing() {
        logger.info("Processing keys")
        for (entry in channel) {
            cacheService.cacheData(entry)
        }
    }

    suspend fun evictCache() = coroutineScope {
        while (isActive) {
            delay(2000)
            cacheService.evictCache()
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(CacheManagerService::class.java)
    }
}