package com.kss.articles.article009

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class HelloServiceTest {

    @MockBean
    private lateinit var helloService: HelloService

    @Test
    fun `hello world`() {
        `when`(helloService.hello()).thenReturn("Hello, mocked world!")
        assertEquals("Hello, mocked world!", helloService.hello())
    }
}
