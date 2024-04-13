package com.kss.articles.article003.coroutines.builders.general

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory

class BuilderRunBlockinMain{
    companion object{
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}

fun main() {
    val logger = LoggerFactory.getLogger("BuilderRunBlockinMain")
    runBlocking {
        logger.info("Hello,")
        delay(500)
    }
    runBlocking {
        logger.info("World")
        delay(500)
    }
    runBlocking {
        logger.info("!")
        delay(500)
    }
}