package com.example.secondkotlin.viewpager

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.viewpager.widget.PagerAdapter

class MyAdapter(private var mlist :List<View> ) : PagerAdapter() {


    override fun getCount(): Int {
        return mlist.size
    }

    /**
     * 创建给定位置的页面。适配器负责*将视图添加到此处给定的容器中，
     * 尽管仅*必须确保该操作在* {@link #finishUpdate（ViewGroup）}返回之前完成
     * 每个viewoager都会有一个key标识
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        /*container.addView(mlist[position],0)
        Log.i("position",position.toString())
        return mlist[position]*/
        container.addView(mlist[position],position)
        Log.i("position",position.toString())
        return container.get(position)
    }

    /**
     * 确定页面视图是否与{@link #instantiateItem（ViewGroup，int）}返回的特定键对象*关联。
     * 该方法是PagerAdapter正常运行所必需的
     */
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        Log.i("view == `object`", (view == `object`).toString())
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(mlist[position])
    }
}