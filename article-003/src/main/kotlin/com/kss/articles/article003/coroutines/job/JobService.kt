package com.kss.articles.article003.coroutines.job

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import kotlin.random.Random

class JobService {

    suspend fun doWorkWithJob() = coroutineScope {
        logger.info("Parent ${Thread.currentThread().name}")
        val job1 = doWorkWithJobAndChildren()
        val job2 = doWorkWithJobAndChildren()
        val job3 = doWorkWithJobAndChildren()

        job1.join()
        job2.join()
        job3.join()
        logger.info("Jobs are finished")
    }

    suspend fun doWorkWithJobAndChildren() = coroutineScope {
        launch {
            delay(Random.nextLong(1000, 2000))
            logger.info("Child ${Thread.currentThread().name}")
        }
    }

    suspend fun workWithJob2() {
        coroutineScope {
            val job = Job()
            launch(job) {
                repeat(5) { num ->
                    delay(Random.nextLong(200, 400))
                    logger.info("Child $num")
                }
            }

            launch {
                delay(500)
                job.complete()
            }

            job.join()
            launch(job) {
                logger.info("Nothing !!!")
            }

            logger.info("Job is finished")
        }
    }

    suspend fun workWithJob3() {
        coroutineScope {
            val job = Job()
            launch(job) {
                repeat(5) { num ->
                    delay(Random.nextLong(200, 400))
                    logger.info("Child $num")
                }
            }

            launch {
                delay(500)
                job.completeExceptionally(Exception("Job failed"))
            }

            job.join()

            launch(job) {
                logger.info("Nothing !!!")
            }

            logger.info("Job is finished")
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }
}