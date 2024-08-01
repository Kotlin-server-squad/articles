package cz.kss.article008.enuminaction

class EnumInActionService {
    fun processResult(result: Result) {
        when (result) {
            Result.SUCCESS -> println("Success")
            Result.FAILURE -> println("Failure")
            Result.IN_PROGRESS -> println("In progress")
        }
    }
}