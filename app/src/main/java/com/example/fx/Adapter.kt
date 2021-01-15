package com.example.fx

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (
    var list: MutableList<Country>,
    private val context: Context,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<Adapter.MyViewHolder>(){

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var country: TextView = view.findViewById(R.id.country)
    }

    interface ItemClickListener{
        fun itemClick(positions: Int, Item: Country?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view = LayoutInflater.from(context).inflate(r.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.country.text = item.country
        holder.itemView.setOnClickListener {
            listener.itemClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}