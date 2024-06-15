package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import org.slf4j.LoggerFactory
import kotlin.random.Random

class FlightRepository {
    suspend fun getFlightsForDestination(): Flow<Flight> {
       val flights = mutableListOf<Flight>()
        repeat(20){
            flights.add(generateRandomFlight())
        }

       return flights.asFlow()
    }

    fun getRandomCompany(): Company {
        val companies = Company.values()
        return companies[Random.nextInt(companies.size)]
    }

    fun getRandomAirportCode(): String {
        val airportCodes = listOf(
            "ATL", "PEK", "DXB", "LAX", "HND", "ORD", "LHR", "HKG", "PVG", "CDG",
            "DFW", "AMS", "FRA", "IST", "CAN", "JFK", "SIN", "ICN", "DEN", "BKK",
            "SFO", "LAS", "CLT", "MIA", "PHX", "IAH", "SEA", "MCO", "EWR", "MSP",
            "FLL", "DTW", "BOS", "PHL", "LGA", "MDW", "DCA", "SAN", "TPA", "BWI",
            "SLC", "IAD", "HNL", "PDX", "STL", "MCI", "BNA", "AUS", "DAL", "HOU",
            "MSY", "SMF", "RDU", "SJC", "OAK", "CLE", "MKE", "SAT", "PIT", "CVG",
            "IND", "CMH", "PBI", "JAX", "RSW", "BDL", "SNA", "OMA", "OKC", "ALB",
            "TUL", "SAV", "BUF", "RIC", "BOI", "ONT", "ORF", "ELP", "TUS", "BUR",
            "ROC", "TYS", "RNO", "CHS", "LIT", "LGB", "PVD", "SFB", "PWM", "GRR"
        )
        return airportCodes[Random.nextInt(airportCodes.size)]
    }

    fun generateRandomFlight(): Flight {
        val from = getRandomAirportCode()
        var to = getRandomAirportCode()
        while (to == from) {
            to = getRandomAirportCode()
        }
        val company = getRandomCompany()

        return Flight(from, to, company)
    }


    companion object{
        val logger = LoggerFactory.getLogger(FlightRepository::class.java)
    }
}