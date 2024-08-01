package cz.kss.article008.whenif

interface Expr
class Num(val value: Int) : Expr // #1
class Sum(val left: Expr, val right: Expr) : Expr // #2

fun eval(e: Expr): Int{
    if(e is Num){
        return e.value
    }
    if(e is Sum){
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int {
    if(e is Num){
        return e.value
    }else if(e is Sum){
        return eval2(e.left) + eval2(e.right)
    }else{
        throw IllegalArgumentException("Unknown expression")
    }
}

fun eval3(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval3(e.left) + eval3(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

class WhenIfMain {}

fun main() {
    println(eval(Sum(Sum(Sum(Num(1), Num(2)), Num(3)), Num(4))))
    println(eval2(Sum(Sum(Sum(Num(1), Num(2)), Num(3)), Num(4))))
    println(eval3(Sum(Sum(Sum(Num(1), Num(2)), Num(3)), Num(4))))
}