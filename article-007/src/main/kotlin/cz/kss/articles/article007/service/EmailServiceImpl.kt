package cz.kss.articles.article007.service

import org.jobrunr.jobs.annotations.Job
import org.jobrunr.jobs.annotations.Recurring
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl() : EmailService {
    override fun sendEmail(email: String, subject: String, message: String) {
        logger.info("Sending email to $email with subject $subject and message $message")
    }

    companion object {
        val logger = LoggerFactory.getLogger(EmailServiceImpl::class.java)
    }
}