package cz.kss.article008.collections

class CollectionsJoinString

fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
val integers = listOf(1, 2, 3, 4, 5)
println(joinToString(integers,";","[","]"))
}