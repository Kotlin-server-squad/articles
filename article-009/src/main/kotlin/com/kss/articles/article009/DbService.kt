package com.kss.articles.article009

class DbService(private val config: DbConfig) {
    fun connect(): String {
        return "Connected to ${config.url}"
    }
}
