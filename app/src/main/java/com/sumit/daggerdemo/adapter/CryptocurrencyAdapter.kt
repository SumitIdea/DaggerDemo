package com.sumit.daggerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sumit.daggerdemo.R
import com.sumit.daggerdemo.model.Cryptocurrency

class CryptocurrencyAdapter(private val cryptocurrency: List<Cryptocurrency>) : RecyclerView.Adapter<CryptocurrencyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating list data from list_item to view
        if (viewType == 1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptocurrency[position])
    }
//
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(mList[position].viewType)
//    }
    override fun getItemCount(): Int {
        return cryptocurrency.size
    }

    //ViewHolder Class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(index: Cryptocurrency) {
            // Here, we are using Glide library to
            // load the image into ImageView
            Glide.with(itemView.context)
                .load(index.image).dontAnimate()
                .into(itemView.findViewById(R.id.image))
            // Setting name of cryptocurrency to TextView
            itemView.findViewById<TextView>(R.id.cryptocurrency).text = index.name
        }
    }


}
