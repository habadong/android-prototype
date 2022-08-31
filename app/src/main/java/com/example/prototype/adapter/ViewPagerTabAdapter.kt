package com.example.prototype.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prototype.R


class ViewPagerTabAdapter(list: ArrayList<String>) : RecyclerView.Adapter<ViewPagerTabAdapter.PagerViewHolder>() {
    val item = list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerTabAdapter.PagerViewHolder {
        return PagerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewPagerTabAdapter.PagerViewHolder, position: Int) {
        holder.tab.text = item[position]
    }

    override fun getItemCount(): Int = item.size

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.main_tab_item, parent, false)){

        val tab = itemView.findViewById<TextView>(R.id.tvTab)!!
    }

}