package com.example.prototype.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prototype.R
import com.example.prototype.data.MainContentData
import com.google.android.material.imageview.ShapeableImageView

class MainAdapter(val itemList: List<MainContentData>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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