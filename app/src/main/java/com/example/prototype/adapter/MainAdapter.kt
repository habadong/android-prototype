package com.example.prototype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prototype.R
import com.example.prototype.data.MainContentData
import com.google.android.material.imageview.ShapeableImageView

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var datas = mutableListOf<MainContentData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_content_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemContent = itemView.findViewById<ShapeableImageView>(R.id.itemIvContent)
        private val itemTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val itemText = itemView.findViewById<TextView>(R.id.tvText)

        fun bind(item: MainContentData) {
            itemTitle.text = item.contentTitle
            itemText.text = item.contentText
            Glide.with(itemView).load(item.contentImage).into(itemContent)
        }
    }

}