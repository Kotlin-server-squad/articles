package cz.kss.articles.article007.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.jobrunr.configuration.JobRunr
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreConfig {
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}