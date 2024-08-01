package cz.kss.article008.basics

class Circle(val radius: Double) {
    val circumference: Double
        get() = 2 * Math.PI * radius
}