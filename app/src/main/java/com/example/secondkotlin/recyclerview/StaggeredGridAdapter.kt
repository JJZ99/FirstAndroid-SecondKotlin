package com.example.secondkotlin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondkotlin.R

class StaggeredGridAdapter(
    private val mContext: Context,
) : RecyclerView.Adapter<StaggeredGridAdapter.ItemViewHolder>() {

     var count :Int = 0

    class ItemViewHolder(private var view :View):RecyclerView.ViewHolder(view){
        var image :ImageView = view.findViewById(R.id.pu_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.stagger_adapter, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (position%2!=0){
            holder.image.setImageResource(R.drawable.image3)

        }else{
            holder.image.setImageResource(R.drawable.image4)

        }
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