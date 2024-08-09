package com.kss.articles.article003.coroutines.channel.new.example1

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory

class FirstTouch

fun main(): Unit = runBlocking {
    val logger = LoggerFactory.getLogger(FirstTouch::class.java)
    val notificationService = NotificationService()
    launch {
        notificationService.sendNotifications()
    }
    launch {
        notificationService.receiveNotification()
    }
    logger.info("end of main")
    delay(100000)
}