package com.kss.articles.article003.coroutines.flow

class ListService {

    fun getList(): List<String> {
       return List(3){
            getItem(it)
            getItem(it)
            getItem(it)
        }
    }

    private fun getItem(i: Int): String {
        Thread.sleep(300)
        return "Item$i"
    }
}