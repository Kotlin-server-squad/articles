package com.kss.articles.article010

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory

fun main() = runBlocking<Unit> {
    val logger = LoggerFactory.getLogger("BlockingConsumerProducer")

    val channel = Channel<Int>(capacity = 10)

    // Coroutine for sending
    launch {
        for (x in 0..15) {
            channel.send(x) // suspends when the channel is full
            logger.info("Sent: $x")
        }
        channel.close() // Close the channel to indicate no more elements will be sent
        logger.info("Producer finished")
    }

    // Coroutine for receiving
    launch {
        // Wait a bit before starting to consume
        delay(2000)
        for (y in channel) { // iterates until the channel is closed
            logger.info("Received: $y")
        }
        logger.info("Consumer finished")
    }
}
