package cz.kss.articles.article007.component

import cz.kss.articles.article007.service.JobSchedulerService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApplicationRunnerService(
    private val jobSchedulerService: JobSchedulerService
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        jobSchedulerService.fireAndForgotJob()
    }
}