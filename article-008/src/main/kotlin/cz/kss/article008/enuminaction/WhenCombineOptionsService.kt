package cz.kss.article008.enuminaction

import java.util.*

class WhenCombineOptionsService {
    fun combineOptions(value: Int){
        when(value){
            1,3,5,7,9 -> println("Odd")
            2,4,6,8,10 -> println("Even")
        }
    }

    fun combineOptionsWithRange(value: Int){
        when(value){
            in 1..5 -> println("Between 1 and 5")
            in 6..10 -> println("Between 6 and 10")
        }
    }

    fun scopedVariableInWhen(){
        when(val response = callHttpService()){
            Result.SUCCESS -> println("Success")
            Result.FAILURE -> println("Failure")
            Result.IN_PROGRESS -> println("In progress")
        }
    }

    fun callHttpService(): Result {
        return Result.SUCCESS
    }

    enum class Result {
        SUCCESS,FAILURE,IN_PROGRESS
    }

    fun whenWithoutArguments(order: Order){
        when{
            order.amount > 1000 && order.currency == Currency.EUR -> println("High value order in EUR")
            order.amount < 1000 && order.currency == Currency.USD -> println("Low value order in USD")
            order.amount > 1000 && order.currency == Currency.GBP -> println("High value order in GBP")
            else -> println("Not covered case")
        }
    }

    data class Order(val id: Int, val amount: Double, val currency: Currency)

    enum class Currency {
        EUR,USD,GBP
    }

}