package com.kss.articles.article003.coroutines.builders.restaurant.service.impl

import com.kss.articles.article003.coroutines.builders.restaurant.domain.Meal
import com.kss.articles.article003.coroutines.builders.restaurant.domain.Order
import com.kss.articles.article003.coroutines.builders.restaurant.service.KitchenService
import com.kss.articles.article003.coroutines.firstmeet.coroutine.restaurant.service.KitchenCoroutineServiceImpl
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.util.logging.Logger

class KitchenServiceImpl: KitchenService {
    override suspend fun prepareOrder(order: Order): Meal {
        return when(order.meal){
            Meal.PASTA -> preparePasta()
            Meal.SALAD -> prepareSalad()
            Meal.SOUP -> prepareSoup()
            Meal.BURGER ->prepareBurger()
        }
    }

    private suspend fun prepareSoup(): Meal = coroutineScope {
        val vegetableDeferred = async { prepareVegetable() }
        val beefBrothDeferred = async{ prepareBeefBroth() }
        if (vegetableDeferred.await() && beefBrothDeferred.await()) {
            logger.info("Soup is ready!")
            return@coroutineScope Meal.SOUP
        }else{
            throw Exception("Soup is not ready")
        }
    }

    private suspend fun prepareSalad(): Meal = coroutineScope{
        val vegetableDeferred = async { prepareVegetable() }
        if (vegetableDeferred.await()) {
            logger.info("Salad is ready!")
            return@coroutineScope Meal.SALAD
        }else{
            throw error("Salad is not ready!")
        }
    }

    private suspend fun prepareBeefBroth(): Boolean {
        logger.info("Preparing beef broth")
        // Simulate the time to prepare the beef broth - for example delay from I/O operation or DB operation
        delay(500)
        return true;
    }

    private suspend fun preparePasta(): Meal = coroutineScope {
        val pastaDeferred = async { prepareSpaghetti() }
        val sauceDeferred = async { prepareSauce() }
        val meatDeferred = async { prepareMeat() }
        if (pastaDeferred.await() && sauceDeferred.await() && meatDeferred.await()) {
            logger.info("Pasta is ready!")
            return@coroutineScope Meal.PASTA
        }else{
            throw Exception("Pasta is not ready")
        }
    }

    private suspend fun prepareBurger() = coroutineScope {
        val pastryDeferred = async { preparePastry() }
        val meatDeferred = async { prepareMeat() }
        val vegetableDeferred = async { prepareVegetable() }

        if (pastryDeferred.await() && meatDeferred.await() && vegetableDeferred.await()) {
            logger.info("Burder is ready!")
            return@coroutineScope Meal.BURGER
        }else{
            throw Exception("Burger is not ready")
        }
    }

    private suspend fun preparePastry(): Boolean {
        logger.info("Preparing pastry")
        // Simulate the time to prepare the pastry - for example delay from I/O operation or DB operation
        delay(200)
        return true;
    }

    private suspend fun prepareSpaghetti(): Boolean {
        logger.info("Preparing spaghetti")
        // Simulate the time to prepare the spaghetti - for example delay from I/O operation or DB operation
        delay(300)
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