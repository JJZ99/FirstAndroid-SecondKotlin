package com.example.secondkotlin.viewpager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity(){

    private lateinit var binding :ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var lf : LayoutInflater = LayoutInflater.from(this)
        var view1 = lf.inflate(R.layout.viewpager_layout1, null)
        var view2 = lf.inflate(R.layout.viewpager_layout2, null)
        var view3 = lf.inflate(R.layout.viewpager_layout3, null)
        var list = mutableListOf<View>()
        list.add(view1)
        list.add(view2)
        list.add(view3)

        var myAdapter = MyAdapter(list)

        binding.viewpage.adapter = myAdapter
        binding.viewpage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            //如果页面滑动了
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.i("PagerListener", " scrolled $position")
            }
            //显示当前页面的位置
            override fun onPageSelected(position: Int) {
                // Toast.makeText(this,"PageSelected $position",Toast.LENGTH_SHORT).show()
                Log.i("PagerListener", " PageSelected $position")
            }

            //页面滑动状态的改变，0表示空闲稳定的状态，1表示正在被拖动 2表示定位到最终位置
            override fun onPageScrollStateChanged(state: Int) {
                Log.i("PagerListener", "ScrollState $state")
            }

        })

    }

}




