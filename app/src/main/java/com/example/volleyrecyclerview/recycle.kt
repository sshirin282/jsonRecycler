package com.example.volleyrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
      //  val contact: List<DataModel> = .get(position)
        //Log.d("Size of User Foods", list.get(position).name.toString());
        holder.textView.text =list.get(position).name
        }
    }

