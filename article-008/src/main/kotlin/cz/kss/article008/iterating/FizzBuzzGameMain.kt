package cz.kss.article008.iterating

fun fizzBuzz(value: Int): String{
    return when{
        value % 15 == 0 -> return "FizzBuzz"
        value % 3 == 0 -> return "Fizz"
        value % 5 == 0 -> return "Buzz"
        else -> "$value"
    }
}

class FizzBuzzGameMain {}

fun main() {
    println("=====================================")
    for(i in 1..100){
        println(fizzBuzz(i))
    }
    println("=====================================")
    for(i in 100 downTo 2 step 1){
        println(fizzBuzz(i))
    }
}