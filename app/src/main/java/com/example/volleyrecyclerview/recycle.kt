package com.example.volleyrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class recycle(val context: Context,val  list: List<DataModel>)
    : RecyclerView.Adapter<recycle.ViewHolder>() {

    private  val inflater: LayoutInflater
            =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val textView: TextView =view.findViewById(R.id.text1)
        val image1: ImageView =view.findViewById(R.id.image2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycle.ViewHolder {
        val rowView=inflater.inflate(R.layout.list, parent, false)
        return ViewHolder(rowView)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text =list.get(position).name
        Glide.with(context)
                .load(list.get(position).image)
                .into(holder.image1)
        }
    }

