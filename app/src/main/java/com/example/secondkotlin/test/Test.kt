package com.example.secondkotlin.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityTestBinding

class Test : AppCompatActivity() {
    private lateinit var binder: ActivityTestBinding

    inner class Dice(val numberSides: Int) {
        fun roll(): Int {
            return (1..numberSides).random()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder= ActivityTestBinding.inflate(layoutInflater)
        setContentView(binder.root)

        val myFirstDice = Dice(10)

        binder.testButton.setOnClickListener {

            var number = myFirstDice.roll()
            //更改文字
            when(number){
                //设置文字
                1-> binder.testId.text = "大三大四风景"
                2->binder.testId.text = "仿佛马上付款时间内"
                3->binder.testId.text = "大三快到"
                4->binder.testId.text = "9998"
                5->binder.testId.text = "12345678！！！！"
                6->binder.testId.text = "0"
                7->binder.testId.text = "OK秘诀呢"
                8->binder.testId.text = "哦里"
                9->binder.testId.text = "却啊没开车"
                10->binder.testId.text = "适当的大叔大"
            }
            binder.showWidth.apply {
                setText(binder.testId.paint.measureText(binder.testId.text.toString()).toString()+ "\n"+binder.testId.width.toString()
                )
            }
        }






    }
}
class Dice(val numberSides: Int) {
    fun roll(): Int {
        return (1..numberSides).random()
    }
}