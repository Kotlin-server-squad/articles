package com.kss.articles.article003.coroutines.flow

import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

class FlowMain {}

fun main() = runBlocking{
    val measureTime = measureTime {
        val listService = ListService()
        listService.getList().forEach { println(it) }
    }
    println("Time in milliseconds: $measureTime")

    val measureTimeSeq = measureTime {
        val sequenceService = SequenceService()
        sequenceService.getSequence().forEach { println(it) }
    }
    println("Time in milliseconds: $measureTimeSeq")

    val measureTimeFlow = measureTime {
        val flowService = FlowService()
        flowService.getFlow().collect(){ println(it) }
    }
    println("Time in milliseconds: $measureTimeFlow")
}