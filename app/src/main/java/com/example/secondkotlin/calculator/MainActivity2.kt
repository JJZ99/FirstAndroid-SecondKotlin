package com.example.secondkotlin.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityCalculatorBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binder : ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.button2.setOnClickListener{
            //通过判断长度是否为0，来确定有没有输入
            if (binder.editTextTextPersonName.length() != 0) {
                var tipPercentage : Double= when(binder.radioGroup.checkedRadioButtonId){
                    R.id.radioButton -> 0.2
                    R.id.radioButton2 -> 0.18
                    R.id.radioButton3 -> 0.15
                    else -> 0.0
                }
                var tip  = tipPercentage * (binder.editTextTextPersonName.text.toString().toDouble())
                binder.textView3.text = (binder.editTextTextPersonName.text.toString().toDouble() * 0.15).toString()

                if (binder.switch1.isChecked){
                    tip = kotlin.math.ceil(tip)
                }
                binder.textView3.text = tip.toString()
            } else {
                binder.textView3.setText("没有输入！！")
            }
        }
    }
}


