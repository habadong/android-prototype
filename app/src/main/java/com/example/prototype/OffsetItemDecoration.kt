package com.example.prototype

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class OffsetItemDecoration(private val value: Int, private val str: String) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view) // get item index
        val count = state.itemCount // item count
        val offset = value
        val type = str

        if(type == "tab") {
            outRect.right = offset
            outRect.left = offset
        } else if(type == "content") {
            outRect.top = offset
            outRect.bottom = offset
        } else {
            outRect.top = offset
            outRect.right = offset
            outRect.bottom = offset
            outRect.left = offset
        }


    }
}