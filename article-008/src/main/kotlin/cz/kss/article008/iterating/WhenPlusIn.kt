package cz.kss.article008.iterating

class WhenPlusIn

fun recognizeLatterOrDigit(char: Char) = when {
    char in 'A'..'Z' || char in 'a'..'z' -> "Latter"
    char in '0'..'9' -> "Digit"
    else -> "Unknown"
}


fun main() {
    recognizeLatterOrDigit('A').also(::println)
    recognizeLatterOrDigit('a').also(::println)
    recognizeLatterOrDigit('Z').also(::println)
    recognizeLatterOrDigit('z').also(::println)
    recognizeLatterOrDigit('0').also(::println)
    recognizeLatterOrDigit('^').also(::println)
}