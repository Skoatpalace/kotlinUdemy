package com.example.appliudemy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/*TODO Adapter du recyclerView*/

class CountryAdapter(val countries: Array<String>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val name = itemView.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.item_country, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.icon.setImageResource(R.mipmap.ic_launcher_round)
        holder.name.text = country
    }

    override fun getItemCount(): Int {
        return countries.size
    }


}