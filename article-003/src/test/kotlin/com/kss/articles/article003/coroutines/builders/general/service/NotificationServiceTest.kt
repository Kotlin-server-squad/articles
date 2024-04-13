package com.kss.articles.article003.coroutines.builders.general.service

import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import service.NotificationService

class NotificationServiceTest{
    @Test
    fun `send notifications = sucess`() = runTest {
        val notificationService = NotificationService()
        val result = notificationService.sendNotifications()
        assertTrue(result.isCompleted)
    }
}