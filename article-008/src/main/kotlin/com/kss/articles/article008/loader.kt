package com.kss.articles.article008

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    val baseUrl = "http://localhost:8080/meetings"
    val meetingIds = List(30) { generateRandomString() }

    coroutineScope {
        meetingIds.forEach {
            val payload = MeetingId(it)
            launch {
                // Start the meeting
                try {
                    val startResponse = client.post("$baseUrl/start") {
                        contentType(ContentType.Application.Json)
                        setBody(payload)
                    }
                    if (startResponse.status.isSuccess()) {
                        println("Started meeting $it")
                    } else {
                        println("Failed to start meeting $it")
                    }
                } catch (e: Exception) {
                    println("Failed to start meeting $it: ${e.message}")
                }
            }
        }

        // End the first X meetings
        meetingIds.take(26).forEach {
            val payload = MeetingId(it)
            launch {
                // Wait for a moment before ending the meeting
                val delay = (1000.. 60_000).random()
                delay(delay.toLong())

                // End the meeting
                try {
                    val endResponse = client.post("$baseUrl/end") {
                        contentType(ContentType.Application.Json)
                        setBody(payload)
                    }
                    if (endResponse.status.isSuccess()) {
                        println("Ended meeting $it")
                    } else {
                        println("Failed to end meeting $it")
                    }
                } catch (e: Exception) {
                    println("Failed to end meeting $it: ${e.message}")
                }
            }
        }
    }
    client.close()
}

private fun generateRandomString(): String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..10)
        .map { allowedChars.random() }
        .joinToString("")
}

@Serializable
data class MeetingId(val id: String)
