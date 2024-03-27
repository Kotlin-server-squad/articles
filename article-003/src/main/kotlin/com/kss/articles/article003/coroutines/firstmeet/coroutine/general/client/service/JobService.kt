package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.JobResponse

interface JobService {
    suspend fun getJob(userId: String): JobResponse
}