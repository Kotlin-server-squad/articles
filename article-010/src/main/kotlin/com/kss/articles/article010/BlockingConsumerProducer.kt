package com.kss.articles.article010

import org.slf4j.LoggerFactory
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val logger = LoggerFactory.getLogger("BlockingConsumerProducer")
    // Create a shared queue with max capacity of 10 elements
    val queue: BlockingQueue<Int> = LinkedBlockingQueue(10)

    val producer = Thread(Producer(queue)).apply { name = "producer" }
    val consumer = Thread(Consumer(queue)).apply { name = "consumer" }

    // Start both threads
    producer.start()
    consumer.start()

    // Wait to finish
    producer.join()
    consumer.join()

    logger.info("Main finished")
}

class Producer(private val queue: BlockingQueue<Int>) : Runnable {
    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun run() {
        for (i in 0..15) {
            queue.put(i)    // Blocks when the queue is full
            logger.info("Produced: $i")
        }
        queue.put(POISON_PILL)  // Signal the consumer to finish
        logger.info("Producer finished")
    }
}

class Consumer(private val queue: BlockingQueue<Int>) : Runnable {
    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun run() {
        // Wait a bit before starting to consume
        Thread.sleep(2000)
        while (true) {
            val i = queue.take()    // Blocks when the queue is empty
            if (i == POISON_PILL) {
                logger.info("Consumer finished")
                return
            } else {
                logger.info("Consumed: $i")
            }
        }
    }
}
const val POISON_PILL = Int.MIN_VALUE
