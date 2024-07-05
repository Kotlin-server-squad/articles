package com.kss.utils

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

/**
 * A mutable clock that can be used for testing.
 * Credit: https://github.com/robfletcher/test-clock
 */
class MutableClock(
    private var instant: Instant,
    private val zoneId: ZoneId
) : Clock() {

    override fun instant(): Instant {
        return instant
    }

    override fun withZone(zone: ZoneId): Clock {
        return MutableClock(instant, zone)
    }

    override fun getZone(): ZoneId {
        return zoneId
    }

    fun advanceBy(millis: Long) {
        instant = instant.plusMillis(millis)
    }
}
