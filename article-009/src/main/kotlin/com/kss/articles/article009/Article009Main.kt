package com.kss.articles.article009

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class Article009Main

fun main(args: Array<String>) {
    runApplication<Article009Main>(*args)
}

