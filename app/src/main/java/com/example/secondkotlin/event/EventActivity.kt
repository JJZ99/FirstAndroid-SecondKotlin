package com.example.secondkotlin.event

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity(){
    private lateinit var binder : ActivityEventBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.btnMy1.setOnClickListener {
            Log.i("Mybutton", "--OnClickListener-")
        }

        binder.btnMy1.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> Log.i("MyButton", "--onTouchListener-Down-")
                MotionEvent.ACTION_UP -> Log.i("MyButton", "--onTouchListener-Up-")
            }
            false
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN-> Log.i("Activity","--onTouchEvent-Down-")
            MotionEvent.ACTION_UP-> Log.i("Activity","--onTouchEvent-Up-")
        }
        return false
    }

    //重写调度触摸事件
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN-> Log.i("Activity","--dispatchTouchEvent-Down-")
            MotionEvent.ACTION_UP-> Log.i("Activity","--dispatchTouchEvent-Up-")
        }
        return super.dispatchTouchEvent(ev)
    }

}