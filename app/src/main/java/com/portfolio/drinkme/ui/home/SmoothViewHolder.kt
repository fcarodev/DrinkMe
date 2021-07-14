package com.portfolio.drinkme.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.drinkme.ui.home.adapter.SmoothAdapter

abstract class SmoothViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(item: T, itemClickListener: SmoothAdapter.SmoothClickListener)
}