package com.example.secondkotlin.recyclerview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondkotlin.R

class GridRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_recycler_view)
        var mRvGrid : RecyclerView = findViewById(R.id.rv_grid)
        //每行三个！！！
        mRvGrid.layoutManager = GridLayoutManager(this, 3)
        mRvGrid.addItemDecoration(MyDecoration())
        mRvGrid.adapter = GridAdapter(this)

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
            outRect.set(3,20,3,3)
        }


    }
}