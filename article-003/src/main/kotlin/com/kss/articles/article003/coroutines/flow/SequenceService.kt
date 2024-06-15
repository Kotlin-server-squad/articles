package com.kss.articles.article003.coroutines.flow

class SequenceService {

    fun getSequence(): Sequence<String> = sequence{
        repeat(3) {
            Thread.sleep(300)
            yield("Item$it")
        }
    }
}