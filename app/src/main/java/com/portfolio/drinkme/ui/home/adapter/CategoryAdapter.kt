package com.portfolio.drinkme.ui.home.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.drinkme.R
import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.ui.home.CategoryViewHolder
import com.portfolio.drinkme.utils.constants.ITEM_EMPTY_DATA
import com.portfolio.drinkme.utils.constants.ITEM_PLACEHOLDER
import kotlinx.android.synthetic.main.item_row_category.view.*

class CategoryAdapter(val itemClickListener: CategoryClickListener) : RecyclerView.Adapter<CategoryViewHolder<*>>() {

    private var categoryList = mutableListOf<Category>() //retorna un ArrayList

    fun setListSmooth(categoryList: MutableList<Category>){
        this.categoryList = categoryList
    }

    inner class CategoryViewPlaceholder(itemView: View): CategoryViewHolder<Category>(itemView){
        override fun bindView(item: Category, itemClickListener: CategoryClickListener) {

        }

    }
    inner class CategoryViewEmptyData(itemView: View): CategoryViewHolder<Category>(itemView){
        override fun bindView(item: Category, itemClickListener: CategoryClickListener) {

        }

    }
    inner class CategoryViewHolderData(itemView: View): CategoryViewHolder<Category>(itemView){
        override fun bindView(item: Category, itemClickListener: CategoryClickListener) {
            val id: Int = itemView.context.getResources().getIdentifier("com.portfolio.drinkme:drawable/${item.imgUrl}", null, null)
            val csl = ColorStateList.valueOf(Color.parseColor(item.tintColor.toString().replace("#","#33")))

            itemView.imgCategoryRecycler.setIconResource(id)
            itemView.imgCategoryRecycler.iconTint = ColorStateList.valueOf(Color.parseColor(item.tintColor))
            itemView.imgCategoryRecycler.rippleColor = csl
            itemView.txtCategoryNameRecycler.text = item.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder<*> {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_empty_data_category, parent, false)
                CategoryViewEmptyData(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_placeholder_category, parent, false)
                CategoryViewPlaceholder(view)

            }
            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_category, parent, false)
                CategoryViewHolderData(view)
            }
            else -> throw IllegalArgumentException("error view type")
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (categoryList[0].id == ITEM_EMPTY_DATA) {
            return 0
        }
        if (categoryList[0].id == ITEM_PLACEHOLDER) {
            return 1
        }
        return 2
    }

    override fun onBindViewHolder(holder: CategoryViewHolder<*>, position: Int) {
        when (holder) {
            is CategoryAdapter.CategoryViewEmptyData -> holder.bindView(
                Category(ITEM_EMPTY_DATA),
                itemClickListener
            )
            is CategoryAdapter.CategoryViewPlaceholder -> holder.bindView(
                Category(ITEM_PLACEHOLDER),
                itemClickListener
            )
            is CategoryAdapter.CategoryViewHolderData -> holder.bindView(
                categoryList[position],
                itemClickListener
            )
        }
    }
    override fun getItemCount(): Int {
        if (categoryList[0].id == ITEM_EMPTY_DATA) {
            return 1
        }
        if (categoryList[0].id == ITEM_PLACEHOLDER) {
            return 10
        }
        return categoryList.size
    }

    interface CategoryClickListener{
        fun onCategoryClickLinstener(category: Category)
    }
}