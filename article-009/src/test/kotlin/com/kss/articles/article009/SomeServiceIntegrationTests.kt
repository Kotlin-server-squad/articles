package com.kss.articles.article009

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@SpringBootTest
class SomeServiceIntegrationTests {

    companion object {
        private val postgreSQLContainer = PostgreSQLContainer(DockerImageName.parse("postgres:13")).apply {
            withDatabaseName("integration-tests-db")
            withUsername("sa")
            withPassword("sa")
        }

        init {
            postgreSQLContainer.start()
        }
    }

    // No mocking, use the real service out of the box if possible
    @Autowired
    private lateinit var helloService: HelloService

    // Don't use Spring if it doesn't benefit the test
    private lateinit var dbService: DbService

    @BeforeEach
    fun init() {
        // Use the real service with a real database
        dbService = DbService(
            DbConfig(
                url = postgreSQLContainer.jdbcUrl,
                user = postgreSQLContainer.username,
                password = postgreSQLContainer.password
            )
        )
    }

    @Test
    fun `test db`() {
        // Make calls to dbService and test the real interaction with the database
    }
}
