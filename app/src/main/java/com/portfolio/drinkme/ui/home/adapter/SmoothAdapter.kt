package com.portfolio.drinkme.ui.home.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.portfolio.drinkme.R
import com.portfolio.drinkme.model.Smooth
import com.portfolio.drinkme.ui.home.SmoothViewHolder
import com.portfolio.drinkme.utils.constants.ITEM_EMPTY_DATA
import com.portfolio.drinkme.utils.constants.ITEM_PLACEHOLDER
import kotlinx.android.synthetic.main.item_row_category.view.*
import kotlinx.android.synthetic.main.item_row_smooth.view.*

class SmoothAdapter(val itemClickListener:SmoothClickListener) : RecyclerView.Adapter<SmoothViewHolder<*>>() {

    private var smoothList = mutableListOf<Smooth>() //retorna un ArrayList

    fun setListSmooth(smoothList: MutableList<Smooth>){
        this.smoothList = smoothList
    }

    inner class SmoothViewPlaceholder(itemView: View): SmoothViewHolder<Smooth>(itemView){
        override fun bindView(item: Smooth, itemClickListener: SmoothClickListener) {

        }

    }
    inner class SmoothViewEmptyData(itemView: View): SmoothViewHolder<Smooth>(itemView){
        override fun bindView(item: Smooth, itemClickListener: SmoothClickListener) {

        }

    }
    inner class SmoothViewHolderData(itemView: View): SmoothViewHolder<Smooth>(itemView){
        override fun bindView(item: Smooth, itemClickListener: SmoothClickListener) {
            Glide.with(itemView.context).load(item.imgUrl)
                .into(itemView.imgSmoothie)
            val id: Int = itemView.context.getResources().getIdentifier("com.portfolio.drinkme:drawable/${item.category.imgUrl}", null, null)
            itemView.imgCategorySmoothie.setIconResource(id)
            itemView.imgCategorySmoothie.iconTint = ColorStateList.valueOf(Color.parseColor(item.category.backgroundColor))
            itemView.imgCategorySmoothie.setBackgroundColor(Color.parseColor(item.category.tintColor))
            itemView.cardImgColor.setOnClickListener {  }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmoothViewHolder<*> {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_empty_data_smooth, parent, false)
                SmoothViewEmptyData(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_placeholder_smooth, parent, false)
                SmoothViewPlaceholder(view)

            }
            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_smooth, parent, false)
                SmoothViewHolderData(view)
            }
            else -> throw IllegalArgumentException("error view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (smoothList[0].id == ITEM_EMPTY_DATA) {
            return 0
        }
        if (smoothList[0].id == ITEM_PLACEHOLDER) {
            return 1
        }
        return 2
    }

    override fun onBindViewHolder(holder: SmoothViewHolder<*>, position: Int) {
        when (holder) {
            is SmoothAdapter.SmoothViewEmptyData -> holder.bindView(
                Smooth(ITEM_EMPTY_DATA),
                itemClickListener
            )
            is SmoothAdapter.SmoothViewPlaceholder -> holder.bindView(
                Smooth(ITEM_PLACEHOLDER),
                itemClickListener
            )
            is SmoothAdapter.SmoothViewHolderData -> holder.bindView(
                smoothList[position],
                itemClickListener
            )
        }
    }
    override fun getItemCount(): Int {
        if (smoothList[0].id == ITEM_EMPTY_DATA) {
            return 1
        }
        if (smoothList[0].id == ITEM_PLACEHOLDER) {
            return 10
        }
        return smoothList.size
    }


    interface SmoothClickListener{
        fun onSmoothClickListener(smooth: Smooth)
    }
}