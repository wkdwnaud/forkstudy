package com.CodeWave.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButon.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val name = editText.text.toString()

            if (name.isEmpty()) {
                //이름이 빈칸일 경우 다시 입력하게 한다.
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            intent.putIntegerArrayListExtra(
                "result",
                ArrayList(LottoNumberMaker.getLottoNumberFromHash(name))
            )
            intent.putExtra("name", name)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            //            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}


//
//fun getLottoNumberFromHash(name:String):MutableList<Int>{
//    var list = mutableListOf<Int>()
//
//    for(number in 1 .. 45)
//        list.add(number)
//
//    val targetString = SimpleDateFormat("MM-dd-yyyy",Locale.KOREA).format(Date())+name
//
//    list.shuffle(Random(targetString.hashCode().toLong()))
//    return list.subList(0,7)
//}