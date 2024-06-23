package cz.kss.articles.article007.service

interface JobSchedulerService {
    fun scheduleJob()
    fun fireAndForgotJob()
    fun schedulingJob()
    fun recurringJob()
    fun deletingJob()
}