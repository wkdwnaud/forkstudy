package com.CodeWave.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    fun getSuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (number in 1..45) {
            list.add(number)
        }

        list.shuffle()

        //앞에서 7개의 리스트를 랜덤으로 출력한다.
        return list.subList(0, 7)
    }


    fun getLottoNumberFromHash(name: String): MutableList<Int> {
        var list = mutableListOf<Int>()

        for (number in 1..45)
            list.add(number)

        val targetString = SimpleDateFormat("MM-dd-yyyy", Locale.KOREA).format(Date()) + name

        list.shuffle(Random(targetString.hashCode().toLong()))
        return list.subList(0, 7)
    }
}