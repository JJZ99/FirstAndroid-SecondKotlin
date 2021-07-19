package com.example.secondkotlin.recyclerview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.secondkotlin.R

class PuRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pu_recycler_view)
        var mRvPu : RecyclerView =findViewById(R.id.rv_pu)
        //两列
        mRvPu.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRvPu.addItemDecoration(MyDecoration())
        this.application

        mRvPu.adapter = StaggeredGridAdapter(this)
    }
    class MyDecoration() : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            //画了一个矩形，就是有点扁
            outRect.set(view.resources.getDimensionPixelOffset(R.dimen.dividerHeight),20,view.resources.getDimensionPixelOffset(R.dimen.dividerHeight),20)
        }


    }
}