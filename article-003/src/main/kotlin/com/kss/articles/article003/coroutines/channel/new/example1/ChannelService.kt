package com.kss.articles.article003.coroutines.channel.new.example1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory

class ChannelService {
    private val channel: Channel<String>

    constructor() {
        channel = Channel()
    }

    suspend fun sendMessage(message: String) {
        logger.info("Sending message: $message")
        delay(1000)
        channel.send(message)
    }

    fun getChannel() = channel

    companion object {
        val logger = LoggerFactory.getLogger(ChannelService::class.java)
    }
}