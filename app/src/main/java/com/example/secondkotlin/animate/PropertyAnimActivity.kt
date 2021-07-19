package com.example.secondkotlin.animate

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityPropertyAnimBinding

class PropertyAnimActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binder : ActivityPropertyAnimBinding
    val imageView : ImageView by lazy {
        findViewById<ImageView>(R.id.iv_proper)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityPropertyAnimBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.btnProper1.setOnClickListener(this)
        binder.btnProper2.setOnClickListener(this)
        binder.btnProper3.setOnClickListener(this)
        binder.btnProper4.setOnClickListener(this)
        binder.btnProper5.setOnClickListener(this)
        binder.btnProper6.setOnClickListener(this)


        var valueAnimator = ValueAnimator.ofInt(0,100)
        valueAnimator.duration = 2000
        //监听valueAnimator的改变
        valueAnimator.addUpdateListener {
            //valueAnimator 实际的值
            Log.d("addUpdateListener", it.animatedValue.toString())
            //动画的进度
            Log.d("addUpdateListener",it.animatedFraction.toString())
        }
        //开始监听
        valueAnimator.start()

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_proper1 -> {
                //沿y轴旋转两圈，持续两秒  这里的view可以是通过组件获取他们的高宽值
                imageView.animate().rotationYBy(720.0F).setDuration(2000).start()
            }
            R.id.btn_proper2 -> {
                //沿y轴向下平移500，持续两秒，向上是-500
                imageView.animate().translationYBy(500.0f).setDuration(2000).start()
            }
            R.id.btn_proper3 -> {
                //逐渐透明，持续2秒
                imageView.animate().alpha(0.0f).setDuration(2000).start()

            }
            R.id.btn_proper4 -> {
                //沿y轴旋转两圈，持续两秒  这里的view可以是通过组件获取他们的高宽值
                imageView.animate().rotationYBy(720.0F).setDuration(2000).start()
                //沿y轴向下平移500，持续两秒，向上是-500
                imageView.animate().translationYBy(500.0f).setDuration(2000).start()
                //逐渐透明，持续2秒
                imageView.animate().alpha(0.0f).setDuration(2000).start()
            }
            R.id.btn_proper5 -> {
                //对组件tvTest设置动画translationY，移动到500再到300再到200
                var  objectAnim : ObjectAnimator = ObjectAnimator.ofFloat(imageView,"translationY",0f,500f,300f,200f)
                //持续两秒
                objectAnim.duration = 2000
                //开始
                objectAnim.start()
            }
            R.id.btn_proper6 -> {
                //逐渐显现，持续2秒
                imageView.animate().alpha(1f).setDuration(2000).start()
            }

        }
    }
}