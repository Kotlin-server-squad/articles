package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import util.RandomDelayService.getRandomDelay
import kotlin.random.Random

class FlightApiService {
    suspend fun getFlight(flight: Flight): Offer {
        return when (flight.company) {
            Company.AMERICAN_AIRLINES -> geAmericanAirlinesFlight(flight)
            Company.DELTA_AIR_LINES -> getDeltaAirLinesFlight(flight)
            Company.UNITED_AIRLINES -> getUnitedAirlinesFlight(flight)
            Company.SOUTHWEST_AIRLINES -> getSouthwestAirlinesFlight(flight)
            Company.ALASKA_AIRLINES -> getAlaskaAirlinesFlight(flight)
            Company.AIR_CANADA -> getAirCanadaFlight(flight)
            Company.WESTJET -> getWestJetFlight(flight)
            Company.AIR_TRANSAT -> getAirTransatFlight(flight)
            Company.BRITISH_AIRWAYS -> getBritishAirwaysFlight(flight)
            Company.EASYJET -> getEasyJetFlight(flight)
            Company.VIRGIN_ATLANTIC -> getVirginAtlanticFlight(flight)
            Company.LUFTHANSA -> getLufthansaFlight(flight)
            Company.EUROWINGS -> getEurowingsFlight(flight)
            Company.CONDOR -> getCondorFlight(flight)
            Company.AIR_FRANCE -> getAirFranceFlight(flight)
            Company.TRANSAVIA_FRANCE -> getTransaviaFranceFlight(flight)
            Company.IBERIA -> getIberiaFlight(flight)
            Company.VUELING_AIRLINES -> getVuelingAirlinesFlight(flight)
            Company.AIR_EUROPA -> getAirEuropaFlight(flight)
        }
    }

    private fun getRandomDelay(): Long {
        return Random.nextLong(300, 1500)
    }

    private fun getRandomPrice(): Double {
        return Random.nextDouble(100.0, 1000.0)
    }

    suspend fun geAmericanAirlinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting American Airlines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getDeltaAirLinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Delta Air Lines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getUnitedAirlinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting United Airlines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getSouthwestAirlinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Southwest Airlines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getAlaskaAirlinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Alaska Airlines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getAirCanadaFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Air Canada flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getWestJetFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting WestJet flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getAirTransatFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Air Transat flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getBritishAirwaysFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting British Airways flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getEasyJetFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting EasyJet flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getVirginAtlanticFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Virgin Atlantic flight delay: $randomDelay")
        delay(getRandomDelay())
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getLufthansaFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Lufthansa flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getEurowingsFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Eurowings flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getCondorFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Condor flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getAirFranceFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Air France flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getTransaviaFranceFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Transavia France flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getIberiaFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Iberia flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getVuelingAirlinesFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Vueling Airlines flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    suspend fun getAirEuropaFlight(flight: Flight): Offer {
        val randomDelay = getRandomDelay()
        val randomPrice = getRandomPrice()
        logger.info("Getting Air Europa flight delay: $randomDelay")
        delay(randomDelay)
        return Offer(flight.from, flight.to, randomPrice)
    }

    companion object {
        val logger = LoggerFactory.getLogger(FlightApiService::class.java)
    }
}