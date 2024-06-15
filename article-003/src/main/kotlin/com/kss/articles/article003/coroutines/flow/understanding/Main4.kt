package com.kss.articles.article003.coroutines.flow.understanding


import com.kss.articles.article003.coroutines.flow.Flight
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf


class Main4 {}

fun <T,R> Flow<T>.map(
    transform: suspend (T) -> R
): Flow<R> = flow {
    collect { value ->
        emit(transform(value))
    }
}

fun <T, K> Flow<T>.distinctBy(
    keySelector: (T) -> K
) = flow {
    val sentKeys = mutableSetOf<K>()
    collect { value ->
        val key = keySelector(value)
        if (key !in sentKeys) {
            sentKeys.add(key)
            emit(value)
        }
    }
}

suspend fun main() {

    val fl1 = Flight("AA123", 200)
    val fl2 = Flight("AA123", 200)
    val fl3 = Flight("AA124", 200)

    flowOf(fl1, fl2, fl3)
        .map {
                it.flightNumber
            }
        .distinctBy { it}
        .collect() { println(it)}
}

data class Flight(val flightNumber: String, val price: Int)