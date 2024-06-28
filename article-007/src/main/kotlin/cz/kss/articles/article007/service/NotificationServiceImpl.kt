package cz.kss.articles.article007.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationServiceImpl(): NotificationService {
    override fun sendNotification() {
        logger.info("Sending notification somewhere...")
    }

    companion object{
        val logger = LoggerFactory.getLogger(NotificationServiceImpl::class.java)
    }
}