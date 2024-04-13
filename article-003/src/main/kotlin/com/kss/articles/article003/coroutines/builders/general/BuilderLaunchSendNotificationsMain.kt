package com.kss.articles.article003.coroutines.builders.general

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import service.NotificationService

class BuilderLaunchSendNotifications {
}

fun main() {
    val notificationService = NotificationService()
    GlobalScope.launch(CoroutineName("ParentCoroutine")) {
        notificationService.sendNotifications()
    }
    Thread.sleep(2000)
}