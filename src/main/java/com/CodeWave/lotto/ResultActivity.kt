package com.CodeWave.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId = R.drawable.lotto01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //전달받은 결과를 가져온다.
        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")
        val constellation = intent.getStringExtra("constellation")

        //전달 받은 결과가 있을 경우에 아래의 내용을 실행한다.
        result?.let {
            updateLottoBallImage(result.sortedBy { it })
        }

        name?.let {
            view.text = name + "님의 ${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다."
        }

        constellation?.let {
            view.text =
                "${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n ${constellation}의 로또번호입니다."
        }

    }

    private fun updateLottoBallImage(result: List<Int>) {
        if (result.size < 7) return
        // 10 9 8 7 6 5 12 순서이다.

        imageView10.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView9.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView8.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView7.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView6.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView5.setImageResource(lottoImageStartId + (result[5] - 1))
        imageView12.setImageResource(lottoImageStartId + (result[6] - 1))

    }
}


