package com.kss.articles.article003.coroutines.firstmeet.thread.restaurant

import com.kss.articles.article003.coroutines.firstmeet.domain.Order
import java.util.logging.Logger

class KitchenThreadServiceImpl : KitchenThreadService {
    override fun prepareOrder(order: Order) {
        when (order.meal) {
            Order.Meal.BURGER -> prepareBurger()
            Order.Meal.PASTA -> preparePasta()
            Order.Meal.SALAD -> prepareSalad()
            Order.Meal.SOUP -> prepareSoup()
        }
    }

    private fun prepareBurger() {
        val pastryDeffered = preparePastry()
        val meatDeferred = prepareMeat()
        val vegetableDeffered = prepareVegetable()

        if (pastryDeffered && meatDeferred && vegetableDeffered) {
            logger.info("Burder is ready!")
        }
    }

    private fun preparePastry(): Boolean {
        logger.info("Preparing pastry")
        Thread.sleep(200)
        return true
    }

    private fun prepareMeat(): Boolean {
        logger.info("Preparing meat")
        Thread.sleep(500)
        return true
    }

    private fun prepareVegetable(): Boolean {
        logger.info("Preparing vegetable")
        Thread.sleep(300)
        return true
    }

    private fun prepareSauce(): Boolean {
        logger.info("Preparing sauce")
        Thread.sleep(500)
        return true
    }

    private fun prepareSoup() {
        TODO("Not yet implemented")
    }

    private fun prepareSalad() {
        TODO("Not yet implemented")
    }

    private fun preparePasta() {
        TODO("Not yet implemented")
    }

    companion object {
        val logger = Logger.getLogger(KitchenThreadServiceImpl::class.java.name)
    }
}