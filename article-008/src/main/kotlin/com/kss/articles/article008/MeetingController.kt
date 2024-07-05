package com.kss.articles.article008

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/meetings")
class MeetingController(
    private val meetingService: MeetingService
) {

    @PostMapping("/start")
    fun startMeeting(
        @RequestBody request: MeetingRequest
    ): ResponseEntity<Unit> {
        meetingService.startMeeting(request.id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/end")
    fun endMeeting(
        @RequestBody request: MeetingRequest
    ): ResponseEntity<Unit> {
        meetingService.endMeeting(request.id)
        return ResponseEntity.ok().build()
    }

    data class MeetingRequest(val id: String)
}
