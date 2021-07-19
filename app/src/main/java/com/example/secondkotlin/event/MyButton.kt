package com.example.secondkotlin.event

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class MyButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN-> Log.i(  "MyButton","--dispatchTouchEvent-Down-")
            MotionEvent.ACTION_UP-> Log.i("MyButton","--dispatchTouchEvent-Up-")
        }
        return super.dispatchTouchEvent(event)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN-> Log.i("MyButton","--onTouchEvent-Down-")
            MotionEvent.ACTION_UP-> Log.i("MyButton","--onTouchEvent-Up-")
        }
        //这里先不要返回super.onTouchEvent(event)，否则触发不了上一层Activity的TouchEvent
        return super.onTouchEvent(event)
    }


    /*override fun setOnTouchListener(l: OnTouchListener?) {
        Log.i("MyButton","--onTouchListener--")
        super.setOnTouchListener(l)
    }*/


}