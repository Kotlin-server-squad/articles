package com.kss.articles.article008

import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap

@Service
class MeetingService(
    private val clock: Clock,
    private val meterRegistry: MeterRegistry,
) {
    private val logger = LoggerFactory.getLogger(MeetingService::class.java)
    private val meetings = ConcurrentHashMap<String, Meeting>()

    fun startMeeting(id: String) {
        logger.info("Starting meeting with id: $id")
        val meeting = Meeting(id, LocalDateTime.now(clock))
        meetings[id] = meeting
        meterRegistry.counter("meetings.started", "meetingId", id).increment()
    }

    fun endMeeting(id: String) {
        logger.info("Ending meeting with id: $id")
        meetings[id]?.let { meeting ->
            meeting.endedAt = LocalDateTime.now(clock)
            val duration = Duration.between(meeting.startedAt, meeting.endedAt).toSeconds()
            meterRegistry.counter("meetings.ended", "meetingId", id).increment()
            meterRegistry.summary("meetings.duration", "meetingId", id).record(duration.toDouble())
        }
    }

    fun getMeeting(id: String): Meeting? = meetings[id]

    @Scheduled(fixedRate = 60_000)    // 60 seconds
    fun checkForStaleMeetings() {
//        val threeHoursAgo = LocalDateTime.now(clock).minusHours(3)
        val twoMinutesAgo = LocalDateTime.now(clock).minusMinutes(2)
        meetings.filter { it.value.endedAt == null && it.value.startedAt.isBefore(twoMinutesAgo) }
            .forEach {
                logger.warn("Meeting ${it.key} did not end within the expected time frame")
                meterRegistry.counter("meetings.stale", "meetingId", it.key).increment()
            }
    }
}
