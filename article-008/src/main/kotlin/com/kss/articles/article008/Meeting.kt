package com.kss.articles.article008

import java.time.LocalDateTime

data class Meeting(val id: String, val startedAt: LocalDateTime, var endedAt: LocalDateTime? = null)
