package com.example.prototype.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.prototype.R

class ViewPagerBannerAdapter(list: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerBannerAdapter.PagerViewHolder>() {
    var item = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.banner.setImageResource(item[position])
    }

    override fun getItemCount(): Int = item.size

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.main_banner_item, parent, false)){

        val banner = itemView.findViewById<ImageView>(R.id.ivMain)!!
    }


}