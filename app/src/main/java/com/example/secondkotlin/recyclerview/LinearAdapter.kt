package com.example.secondkotlin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.secondkotlin.databinding.LinearItemBinding
import com.example.secondkotlin.recyclerview.LinearAdapter.ItemViewHolder

class LinearAdapter(
    private val mContext: Context,
//    private val onclick: OnItemClickListener
) : Adapter<ItemViewHolder>() {

     var count :Int = 0

    inner class ItemViewHolder(val binding: LinearItemBinding): ViewHolder(binding.root){
        var textView: TextView? = null

        init {
            textView = binding.tvTextview
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder  {
            val bind =
                LinearItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (getItemViewType(position) == 0){
            holder.textView!!.text = "Hello World${count}"
        }else{
            holder.textView!!.text = "我在奔跑${count}"
        }
        ++count
        holder.itemView.setOnClickListener {
            Toast.makeText(mContext,"dasdas",Toast.LENGTH_SHORT).show()
        }
    }

    //这里是要告诉recycler展示几条数据
    override fun getItemCount(): Int {
        return 3
    }

    interface OnItemClickListener{
        fun onClick(pos: Int)
    }

}