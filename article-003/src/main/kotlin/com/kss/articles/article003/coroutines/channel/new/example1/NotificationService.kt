package com.kss.articles.article003.coroutines.channel.new.example1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import org.slf4j.LoggerFactory

class NotificationService {
    private val channelService: ChannelService

    constructor() {
        channelService = ChannelService()
    }

    suspend fun sendNotifications() = coroutineScope {
        logger.info("Sending notifications")
        val jobs = mutableListOf<Job>()
        for (i in 1..5) {
            val job = launch {
                sendNotification()
            }
            jobs.add(job)
        }
        jobs.forEach { println("Job completed: ${it.isCompleted}")}
    }

    suspend fun sendNotifications2(): Unit = coroutineScope {
        produce<Int>{
            repeat(5){
                val message = "$it Notification sent at ${System.currentTimeMillis()}"
                delay(300)
                channelService.sendMessage(message)
            }
        }
    }


    suspend fun sendNotification() = coroutineScope {
        for (i in 1..5) {
                val message = "$i Notification sent at ${System.currentTimeMillis()}"
                delay(300)
                channelService.sendMessage(message)
        }
    }

    suspend fun receiveNotification() = coroutineScope {
        val channel = channelService.getChannel()
        launch {
            channel.consumeEach {
                logger.info("Received message: $it")
            }
        }
    }

    fun getNotificationChannel() = channelService.getChannel()

    companion object {
        val logger = LoggerFactory.getLogger(NotificationService::class.java)
    }
}