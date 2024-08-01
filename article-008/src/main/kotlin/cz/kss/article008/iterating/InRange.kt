package cz.kss.article008.iterating

class InRange

fun isLatter(char: Char) = char in 'A'..'Z' || char in 'a'..'z'
fun isNotDigit(char: Char) = char !in '0'..'9'

fun main() {
    println(isLatter('A'))
    println(isLatter('a'))
    println(isLatter('Z'))
    println(isLatter('z'))
    println(isLatter('0'))
    println(isLatter('9'))
    println(isNotDigit('A'))
    println(isNotDigit('a'))
    println(isNotDigit('Z'))
    println(isNotDigit('z'))
    println(isNotDigit('0'))
    println(isNotDigit('9'))
}