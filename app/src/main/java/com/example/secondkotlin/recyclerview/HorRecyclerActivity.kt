package com.example.secondkotlin.recyclerview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondkotlin.R

class HorRecyclerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hor_recycler)
        var mRvHor = findViewById<RecyclerView>(R.id.rv_hor)
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        //set to horizontal
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mRvHor.layoutManager = linearLayoutManager
        mRvHor.addItemDecoration(MyDecoration())
        mRvHor.adapter = HorAdapter(this)
    }
    class MyDecoration() : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            //画了一个矩形，就是有点扁,可以理解为加了边距
            outRect.set(0,0,20,0)
        }


    }
}