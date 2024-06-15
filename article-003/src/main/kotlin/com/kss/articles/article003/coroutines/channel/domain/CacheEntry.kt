package com.kss.articles.article003.coroutines.channel.domain

data class CacheEntry(
    val key: CacheEntryKey,
    val counter: Int,
)
