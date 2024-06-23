package cz.kss.articles.article007.service

import org.jobrunr.scheduling.BackgroundJob
import org.jobrunr.scheduling.JobRequestScheduler
import org.jobrunr.scheduling.JobScheduler
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class JobSchedulerServiceImpl(
    private val jobScheduler: JobScheduler,
    private val jobRequestScheduler: JobRequestScheduler,
    private val emailService: EmailService,
    private val notificationService: NotificationService,
) : JobSchedulerService {
    override fun scheduleJob() {
       jobScheduler.scheduleRecurrently("*/5 * * * * *") {
           emailService.sendEmail(email ="test", subject = "test", message = "test")
       }
    }

    override fun fireAndForgotJob() {
       jobScheduler.enqueue { notificationService.sendNotification() }
    }

    override fun schedulingJob() {

    }

    override fun recurringJob() {
        TODO("Not yet implemented")
    }

    override fun deletingJob() {
        TODO("Not yet implemented")
    }
}