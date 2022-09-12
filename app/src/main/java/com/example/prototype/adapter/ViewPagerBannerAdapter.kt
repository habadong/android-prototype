package com.example.prototype.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prototype.R
import com.example.prototype.data.BannerData

class ViewPagerBannerAdapter(list: MutableList<BannerData>) : RecyclerView.Adapter<ViewPagerBannerAdapter.PagerViewHolder>() {
    var item = list
//    var item = mutableListOf<BannerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
//        holder.banner.setImageResource(item[position])
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.main_banner_item, parent, false)){

        val banner = itemView.findViewById<ImageView>(R.id.ivMain)!!
        val title = itemView.findViewById<TextView>(R.id.tvBannerTitle)!!
        val subTitle = itemView.findViewById<TextView>(R.id.tvBannerSubTitle)!!

        fun bind(item: BannerData) {
            title.text = item.title
            subTitle.text = item.susTitle
            Glide.with(itemView).load(item.img).into(banner)
        }
    }


}