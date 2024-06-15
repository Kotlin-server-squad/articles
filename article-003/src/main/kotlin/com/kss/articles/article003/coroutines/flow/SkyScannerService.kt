package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import org.slf4j.LoggerFactory

class SkyScannerService {
    private val flightRepository = FlightRepository()
    private val flightApiService = FlightApiService()
    suspend fun getFlightsForDestination(): List<Offer> {
        return flightRepository.getFlightsForDestination()
            .flatMapMerge(concurrency = 5) { destination ->
                suspend {
                    flightApiService.getFlight(destination)
                }.asFlow()
            }.toList()
    }

    companion object {
        val logger = LoggerFactory.getLogger(SkyScannerService::class.java)
    }
}