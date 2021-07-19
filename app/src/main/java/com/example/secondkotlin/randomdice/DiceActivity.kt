package com.example.secondkotlin.randomdice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityDiceBinding

class DiceActivity : AppCompatActivity() {
    private lateinit var binder : ActivityDiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityDiceBinding.inflate(layoutInflater)
        setContentView(binder.root)


        val myFirstDice = Dice(6)
        var number = 1

//        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
//            textView.setText("${myFirstDice.roll()}")
//        }
        //或者
        binder.button.setOnClickListener{ v ->
            number = myFirstDice.roll()
            binder.textview1.text = "${number.toString()}"
            //更改背景颜色
            //v.setBackgroundColor(Color.RED)
            when(number){
                //设置图像资源
                1->binder.imageView.setImageResource(R.drawable.dice_1)
                2->binder.imageView.setImageResource(R.drawable.dice_2)
                3->binder.imageView.setImageResource(R.drawable.dice_3)
                4->binder.imageView.setImageResource(R.drawable.dice_4)
                5->binder.imageView.setImageResource(R.drawable.dice_5)
                6->binder.imageView.setImageResource(R.drawable.dice_6)
            }
            binder.imageView.contentDescription = number.toString()
        }
    }
}

class Dice(val numberSides: Int) {
    fun roll(): Int {
        return (1..numberSides).random()
    }
}
