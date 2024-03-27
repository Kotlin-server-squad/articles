package com.kss.articles.article003.coroutines.firstmeet.coroutine.restaurant.service

import com.kss.articles.article003.coroutines.firstmeet.domain.Order
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.util.logging.Logger

class KitchenCoroutineServiceImpl : KitchenCoroutineService {
    override suspend fun prepareOrder(order: Order) {
        when (order.meal) {
            Order.Meal.BURGER -> prepareBurger()
            Order.Meal.PASTA -> preparePasta()
            Order.Meal.SALAD -> prepareSalad()
            Order.Meal.SOUP -> prepareSoup()
        }
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

    private suspend fun prepareBurger() = coroutineScope {
        val pastryDeferred = async { preparePastry() }
        val meatDeferred = async { prepareMeat() }
        val vegetableDeferred = async { prepareVegetable() }

        if (pastryDeferred.await() && meatDeferred.await() && vegetableDeferred.await()) {
            logger.info("Burder is ready!")
        }
    }

    private suspend fun preparePastry(): Boolean {
        logger.info("Preparing pastry")
        // Simulate the time to prepare the pastry - for example delay from I/O operation or DB operation
        delay(200)
        return true;
    }

    private suspend fun prepareMeat(): Boolean {
        logger.info("Preparing meat")
        // Simulate the time to prepare the meat - for example delay from I/O operation or DB operation
        delay(500)
        return true;
    }

    private suspend fun prepareVegetable(): Boolean {
        logger.info("Preparing vegetable")
        // Simulate the time to prepare the vegetable - for example delay from I/O operation or DB operation
        delay(300)
        return true;
    }

    private suspend fun prepareSauce(): Boolean {
        logger.info("Preparing sauce")
        // Simulate the time to prepare the sauce - for example delay from I/O operation or DB operation
        delay(500)
        return true;
    }

    companion object {
        val logger = Logger.getLogger(KitchenCoroutineServiceImpl::class.java.name)
    }
}