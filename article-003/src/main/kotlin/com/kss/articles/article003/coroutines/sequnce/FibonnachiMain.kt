package com.kss.articles.article003.coroutines.sequnce

import kotlinx.coroutines.yield

class FibonnachiMain

fun main() {
    val fibonacci = FibonacciSequence()
    fibonacci.getFibonacci().take(1000).forEach { println(it) }
}

class FibonacciSequence {
   fun getFibonacci() = sequence{
       var first = 0.toBigInteger()
       var second = 1.toBigInteger()
       while (true){
           yield(first)
           val temp = first
           first += second
           second = temp
       }
   }
}