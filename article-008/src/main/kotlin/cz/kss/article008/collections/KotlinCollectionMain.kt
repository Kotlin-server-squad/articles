package cz.kss.article008.collections

class KotlinCollectionMain

fun main() {
    val strings = listOf("one", "two", "three", "four", "five")
    strings.last().also(::println)
    strings.first().also(::println)
    strings.shuffled().last().also(::println)
    val shuffled = strings.shuffled()
    shuffled.last().also { println(it) }
}