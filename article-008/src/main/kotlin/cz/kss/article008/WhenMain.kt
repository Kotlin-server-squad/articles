package cz.kss.article008

import cz.kss.article008.enuminaction.WhenCombineOptionsService

class WhenMain {}

fun main() {
    val whenCombineOptionsService = WhenCombineOptionsService()
    whenCombineOptionsService.combineOptions(1)
    whenCombineOptionsService.combineOptions(11)
}