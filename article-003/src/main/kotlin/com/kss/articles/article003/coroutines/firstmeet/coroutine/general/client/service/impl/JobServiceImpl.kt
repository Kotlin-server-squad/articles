package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.impl

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.JobResponse
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.JobService
import kotlinx.coroutines.delay
import java.util.UUID

class JobServiceImpl: JobService {
    override suspend fun getJob(userId: String): JobResponse {
        // simulate a I/O operation calling a remote service
        delay(1000)
        return JobResponse(
            id = UUID.randomUUID().toString(), title = "manager", description = "manager in compan"
        )
    }
}