package com.kss.articles.article003.coroutines.job

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class JobMain {
}

fun main() {
    val coroutineScope = Dispatchers.Default
    runBlocking(coroutineScope) {
        val jobService = JobService()
            jobService.workWithJob3()
    }
}