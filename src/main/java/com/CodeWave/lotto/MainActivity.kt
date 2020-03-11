package com.CodeWave.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            //화면을 전환할때 값을 넣어서 전송한다.
            intent.putIntegerArrayListExtra(
                "result",
                ArrayList(LottoNumberMaker.getSuffleLottoNumbers())
            )

            startActivity(intent)
        }

        constellCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}


//
//fun getSuffleLottoNumbers():MutableList<Int>{
//    val list = mutableListOf<Int>()
//    for(number in 1 .. 45){
//        list.add(number)
//    }
//
//    list.shuffle()
//
//    //앞에서 7개의 리스트를 랜덤으로 출력한다.
//    return list.subList(0,7)
//}

//랜덤함수를 7번 사용하는 방법이다.
//fun getRandomNumber():Int{
//    return Random().nextInt(45)+1
//}
//
//fun getRandomLottoNumber():MutableList<Int>{
//    val lottoNumbers = mutableListOf<Int>()
//
//    for (i in 1 ..7){
//        var number = 0;
//        do {
//            number = getRandomNumber()
//
//        }while (lottoNumbers.contains(number))
//        lottoNumbers.add(number)
//    }
//
//    return lottoNumbers
//}


























