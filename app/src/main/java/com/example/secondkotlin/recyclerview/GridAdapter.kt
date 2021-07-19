package com.example.secondkotlin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondkotlin.R

class GridAdapter(
    private val mContext: Context,
) : RecyclerView.Adapter<GridAdapter.ItemViewHolder>() {

     var count :Int = 0

    class ItemViewHolder(private var view :View):RecyclerView.ViewHolder(view){
        var textView :TextView = view.findViewById(R.id.tv_textview)
        //var view2 :View =view.findViewById(R.id.view)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_adapter, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = "Hello Grid${count}"
        ++count
//        holder.textView.setOnClickListener{
//            Toast.makeText(mContext,"dasdas",Toast.LENGTH_SHORT).show()
//        }
    }

    //这里是要告诉recycler展示几条数据
    override fun getItemCount(): Int {
        return 16
    }
    interface OnItemClickListener{
        fun onClick(pos: Int)
    }


}