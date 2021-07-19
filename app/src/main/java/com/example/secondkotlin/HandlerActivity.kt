package com.example.secondkotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityHandlerBinding


class HandlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlerBinding


    private val handler2: Handler by lazy {
        Handler()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //countDownTimer形成计时器     5秒        1秒算一个周期
        var countDownTimer = object : CountDownTimer(5000,1000){
            //每一个周期结束都会自动执行该方法
            override fun onTick(millisUntilFinished: Long) {
                binding.tvHandler.text = (millisUntilFinished / 1000).toString()
                Log.i("Timer Process",binding.tvHandler.text.toString() )
            }
            override fun onFinish() {
                Log.i("Timer Finish", "jump")
            }
        }

        //handler延迟五秒跳转到另一个界面
        //var handler = Handler()
        /*handler.postDelayed(object : Runnable {
            override fun run() {
                var intent = Intent(
                    this@HandlerActivity,
                    com.example.secondkotlin.calculator.MainActivity2().javaClass
                )
                Toast.makeText(this@HandlerActivity,"5秒到了，跳转" ,Toast.LENGTH_SHORT).show()
                Log.i("Timer 5s Delayed",tvTime.text.toString() )
                startActivity(intent)
            }
        }, 5000)*/

        //定时器开始
        //countDownTimer.start()
        var handler2:Handler = object : Handler(){
                //子类必须实现此功能才能接收消息
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    when(msg.what){
                        1 -> Toast.makeText(this@HandlerActivity,"线程通信成功！！！",Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this@HandlerActivity,"无语！！！",Toast.LENGTH_SHORT).show()
                    }
                }
        }

        //创建一个线程，新建消息，handler调用sendmessage发到主线程
        object : Thread(){
            override fun run() {
                super.run()
                var mess  = Message()
                //用户定义的消息代码，以便收件人可以识别此消息的含义
                mess.what = 1
                //发送
                //在当前时间之前所有未决消息之后将消息推送到消息队列的末尾。它将在附加到此处理程序的线程中的handleMessage中被接收
                handler2.sendMessage(mess)
            }
        }.start()

        //下面这段代码不是每隔一秒循环一次，而是一秒后循环五次
        /*for (i in 1..5) {
            handler2.postDelayed(object : Runnable {
                override fun run() {
                    Log.i("Timer handler:",i.toString())
                    tvTime.text = i.toString()
                }
            }, 1000)
        }*/
    }

}