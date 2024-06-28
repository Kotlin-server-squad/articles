package cz.kss.articles.article007.config

import org.jobrunr.configuration.JobRunr
import org.jobrunr.configuration.JobRunrConfiguration.JobRunrConfigurationResult
import org.jobrunr.scheduling.JobRequestScheduler
import org.jobrunr.scheduling.JobScheduler
import org.jobrunr.server.JobActivator
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class JobRurnConfig {
    @Bean
    fun initJobRunr(dataSource: DataSource, jobActivator: JobActivator): JobRunrConfigurationResult {
        return JobRunr.configure()
            .useJobActivator(jobActivator)
            .useStorageProvider(SqlStorageProviderFactory.using(dataSource))
            .useBackgroundJobServer()
            .useDashboard(8801)
            .initialize()
    }

    @Bean
    fun initJobScheduler(jobRunrConfigurationResult: JobRunrConfigurationResult): JobScheduler {
        return jobRunrConfigurationResult.jobScheduler
    }

    @Bean
    fun initJobRequestScheduler(jobRunrConfigurationResult: JobRunrConfigurationResult): JobRequestScheduler {
        return jobRunrConfigurationResult.jobRequestScheduler
    }
}