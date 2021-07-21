package com.example.secondkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.animate.PropertyAnimActivity
import com.example.secondkotlin.animate.TweenAnimActivity
import com.example.secondkotlin.calculator.MainActivity2
import com.example.secondkotlin.databinding.ActivityMainBinding
import com.example.secondkotlin.event.EventActivity
import com.example.secondkotlin.randomdice.DiceActivity
import com.example.secondkotlin.recyclerview.RecyclerViewActivity
import com.example.secondkotlin.test.Test
import com.example.secondkotlin.tiange.TianMainActivity
import com.example.secondkotlin.viewmodel.SeekBarActivity
import com.example.secondkotlin.viewpager.ViewPagerActivity
import com.example.secondkotlin.webview.WebViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //视图绑定的写法
        //调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用
        val view = binding.root
        //将根视图传递到 setContentView()，使其成为屏幕上的活动视图
        setContentView(view)
        binding.Dice.setOnClickListener{
            val intent: Intent = Intent(this.application, DiceActivity::class.java)
            startActivity(intent)
        }
        binding.tiangeCheckbox.setOnClickListener{
            val intent: Intent = Intent(this.baseContext, TianMainActivity::class.java)
            startActivity(intent)
        }
        binding.calculator.setOnClickListener{
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.RecyclerView.setOnClickListener{
            val intent: Intent = Intent(this, RecyclerViewActivity().javaClass)
            startActivity(intent)
        }
        binding.SeekBar.setOnClickListener{
            val intent = Intent(this@MainActivity, SeekBarActivity::class.java)
            startActivity(intent)
        }

        binding.Affirmations.setOnClickListener{
            /*val intent: Intent = Intent(this, RecyclerViewActivity().javaClass)
            startActivity(intent)*/
        }
        binding.WebView.setOnClickListener{
            val intent: Intent = Intent(this, WebViewActivity().javaClass)
            startActivity(intent)
        }
        binding.ViewPager.setOnClickListener{
            val intent: Intent = Intent(this, ViewPagerActivity().javaClass)
            startActivity(intent)
        }
        binding.btnHandler.setOnClickListener {
            var intent = Intent(this, HandlerActivity().javaClass)
            startActivity(intent)
        }
        binding.btnAnim.setOnClickListener {
            var intent = Intent(this, PropertyAnimActivity().javaClass)
            startActivity(intent)
        }
        binding.btnTween.setOnClickListener {
            var intent = Intent(this, TweenAnimActivity().javaClass)
            startActivity(intent)
        }
        binding.btnMy.setOnClickListener {
            var intent = Intent(this, EventActivity().javaClass)
            startActivity(intent)
        }
        binding.testTextview.setOnClickListener {
            var intent = Intent(this, Test().javaClass)
            startActivity(intent)
        }

    }
}

