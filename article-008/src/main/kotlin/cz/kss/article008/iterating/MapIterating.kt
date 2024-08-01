package cz.kss.article008.iterating

import java.util.Currency
import java.util.UUID

class MapIterating {}

fun main() {
    val map = mutableMapOf<Char,String>()
    for (char in 'A'..'F'){
        val binary = char.code.toString(radix = 2)
        map[char] = binary
    }

    for ((key, value) in map){
        println("$key = $value")
    }
}