package com.example.secondkotlin.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //做一个垂直滚动的布局
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLinear.setOnClickListener {
            Toast.makeText(this,"啊哈~",Toast.LENGTH_SHORT).show()

            var intent = Intent(this,LinearRecyclerViewActivity().javaClass)
            Toast.makeText(this,"啊哈~2",Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
        binding.btnHor.setOnClickListener{
            Toast.makeText(this,"啊哈~",Toast.LENGTH_SHORT).show()

            var intent = Intent(this,HorRecyclerActivity().javaClass)
            Toast.makeText(this,"啊哈~2",Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
        binding.btnGrid.setOnClickListener{
            Toast.makeText(this,"啊哈~",Toast.LENGTH_SHORT).show()

            var intent = Intent(this,GridRecyclerViewActivity().javaClass)
            Toast.makeText(this,"啊哈~2",Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
        binding.btnPu.setOnClickListener {
            var intent = Intent(this,PuRecyclerViewActivity().javaClass)
            startActivity(intent)
        }
    }
}