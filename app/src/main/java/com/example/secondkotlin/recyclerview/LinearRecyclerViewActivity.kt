package com.example.secondkotlin.recyclerview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityLinearRecyclerViewBinding

class LinearRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binder : ActivityLinearRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binder = ActivityLinearRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.rvMain.layoutManager = LinearLayoutManager(this)
        binder.rvMain.addItemDecoration(MyDecoration())
        binder.rvMain.adapter = LinearAdapter(this)

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
            outRect.set(0,0,0,view.resources.getDimensionPixelOffset(R.dimen.dividerHeight))
        }


    }

}