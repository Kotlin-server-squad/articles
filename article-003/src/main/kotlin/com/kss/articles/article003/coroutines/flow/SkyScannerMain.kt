package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SkyScannerMain {}

fun main():Unit = runBlocking{
    val skyScannerService = SkyScannerService()
    skyScannerService.getFlightsForDestination() .forEach { println(it) }

    delay(10000)
}