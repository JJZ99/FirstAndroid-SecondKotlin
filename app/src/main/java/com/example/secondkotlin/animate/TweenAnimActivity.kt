package com.example.secondkotlin.animate

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityTweenAnimBinding

class TweenAnimActivity : AppCompatActivity() ,View.OnClickListener {
    private lateinit var binder : ActivityTweenAnimBinding
    val imageView : ImageView by lazy {
        findViewById<ImageView>(R.id.iv_tween)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityTweenAnimBinding.inflate(layoutInflater)
        setContentView(binder.root)
        binder.btnTween1.setOnClickListener(this)
        binder.btnTween2.setOnClickListener(this)
        binder.btnTween3.setOnClickListener(this)
        binder.btnTween4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_tween1 -> {
                var anim = AnimationUtils.loadAnimation(this, R.anim.alp)
                imageView.startAnimation(anim)
            }
            R.id.btn_tween2 -> {
            var anim = AnimationUtils.loadAnimation(this, R.anim.rotate)
            imageView.startAnimation(anim)
            }
            R.id.btn_tween3 -> {
                var anim = AnimationUtils.loadAnimation(this, R.anim.scale)
                imageView.startAnimation(anim)
            }
            R.id.btn_tween4 -> {
                var anim = AnimationUtils.loadAnimation(this, R.anim.translation)
                imageView.startAnimation(anim)
            }
        }
    }
}