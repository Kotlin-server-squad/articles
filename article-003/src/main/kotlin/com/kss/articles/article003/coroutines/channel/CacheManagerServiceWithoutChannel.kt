package com.kss.articles.article003.coroutines.channel

import com.kss.articles.article003.coroutines.channel.domain.CacheEntryKey
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.slf4j.LoggerFactory

class CacheManagerServiceWithoutChannel {
    private val cacheService = CacheService()

    private val evictWorker = Dispatchers.Default.limitedParallelism(1)

    private val evictScope = CoroutineScope(evictWorker)

    val scope = CoroutineScope(Dispatchers.Default)

    init {
        evictScope.launch{
            evictCache()
        }
    }

    suspend fun send(key: CacheEntryKey) = coroutineScope {
        launch {
            logger.info("Sending key")
            delay(100)
            cacheService.cacheData(key)
        }
    }

    suspend fun evictCache() = coroutineScope{
        while (isActive){
            delay(2000)
            cacheService.evictCache()
        }
    }

    companion object{
        val logger = LoggerFactory.getLogger(CacheManagerService::class.java)
    }
}