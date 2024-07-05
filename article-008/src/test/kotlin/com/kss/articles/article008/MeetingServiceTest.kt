package com.kss.articles.article008

import com.kss.utils.MutableClock
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant
import java.time.ZoneId

class MeetingServiceTest {

    private lateinit var meetingService: MeetingService
    private lateinit var meterRegistry: MeterRegistry
    private lateinit var clock: MutableClock

    @BeforeEach
    fun setUp() {
        clock = MutableClock(Instant.parse("2024-01-01T10:00:00Z"), ZoneId.systemDefault())
        meterRegistry = SimpleMeterRegistry()
        meetingService = MeetingService(clock, meterRegistry)
    }

    @Test
    fun `test start meeting`() {
        val initialCount = meetingStartedCount()
        val meetingId = "123"
        meetingService.startMeeting(meetingId)
        assertTrue(meetingStartedCount() == initialCount + 1.0)
    }

    @Test
    fun `test end meeting`() {
        val meetingId = "123"
        meetingService.startMeeting(meetingId)
        clock.advanceBy(60 * 60_000)
        meetingService.endMeeting(meetingId)
        val meeting = meetingService.getMeeting(meetingId)
        assertNotNull(meeting)
        assertNotNull(meeting?.endedAt)
        assertTrue(Duration.between(meeting?.startedAt, meeting?.endedAt).toMinutes() == 60L)
    }

    private fun meetingStartedCount(): Double =
        meterRegistry.find("meetings.started").counter()?.count() ?: 0.0
}
