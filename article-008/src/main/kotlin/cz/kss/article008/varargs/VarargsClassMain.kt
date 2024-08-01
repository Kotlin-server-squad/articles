package cz.kss.article008.varargs

class Pack<T,S>(
    val i1: T,
    val i2: S,
){
    fun putTogether() = "$i1 $i2"
}

infix fun <T,S> T.pack(other:S) = Pack(this, other)

class VarargsClassMain {}

fun main(array: Array<String>) {
    val list = listOf("args: ", *array)
    println(list)
    val test: Pack<String, String> = "Hello" pack "World"
    println(test.putTogether())
}