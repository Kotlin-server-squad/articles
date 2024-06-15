package com.kss.articles.article003.coroutines.channel

import com.kss.articles.article003.coroutines.channel.domain.CacheEntryKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.log

class CacheService {
    private val lockMap = ConcurrentHashMap<CacheEntryKey, Mutex>()
    private val map = ConcurrentHashMap<CacheEntryKey, AtomicInteger>()
    suspend fun cacheData(key: CacheEntryKey){

       lockMap.getOrPut(key) { Mutex() }.withLock {
           val counter = map.getOrPut(key) { AtomicInteger(0) }
//           if(counter.get() < 4) {
               counter.incrementAndGet()
               logger.info("Key: $key, counter: ${counter.get()}")
//           }
       }
    }

   suspend fun evictCache(){
        lockMap.forEach{
            it.value.withLock {
                map[it.key] = AtomicInteger(0)
            }
        }
    }

    companion object{
        val logger = LoggerFactory.getLogger(CacheService::class.java)
    }
}