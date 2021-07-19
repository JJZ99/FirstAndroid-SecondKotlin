package com.example.secondkotlin.tiange

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var binder: ActivityCheckBoxBinding

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.checkbox.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            Toast.makeText(this,"cb",-5).show()
        }
        binder.checkbox2.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            Toast.makeText(this,"cb2",Toast.LENGTH_SHORT).show()
        }
        binder.checkbox3.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            Toast.makeText(this,"cb3",Toast.LENGTH_SHORT).show()
        }
        binder.checkbox4.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            Toast.makeText(this,"cb4",Toast.LENGTH_SHORT).show()
        }
    }

}