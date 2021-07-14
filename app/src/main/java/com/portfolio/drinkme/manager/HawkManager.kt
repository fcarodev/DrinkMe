package com.portfolio.drinkme.manager

import com.orhanobut.hawk.Hawk
import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.model.Smooth
import com.portfolio.drinkme.utils.constants.ACTUAL_CATEGORY
import com.portfolio.drinkme.utils.constants.ACTUAL_SMOOTHIE
import com.portfolio.drinkme.utils.constants.CATEGORY_LIST
import com.portfolio.drinkme.utils.constants.SMOOTHIE_LIST

class HawkManager {

    fun setSmoothieList(smoothieList: MutableList<Smooth>){
        Hawk.put(SMOOTHIE_LIST,smoothieList)
    }

    fun getSmoothieList(): MutableList<Smooth>{
        return if(Hawk.contains(SMOOTHIE_LIST)){
            Hawk.get(SMOOTHIE_LIST)
        }else{
            mutableListOf<Smooth>()
        }
    }

    fun setCategoryList(categoryList: MutableList<Category>){
        Hawk.put(CATEGORY_LIST,categoryList)

    }

    fun getCategoryList():MutableList<Category>{
        return if(Hawk.contains(CATEGORY_LIST)){
            Hawk.get(CATEGORY_LIST)
        }else{
            mutableListOf<Category>()
        }
    }

    fun setActualSmoothie(smooth: Smooth){
        Hawk.put(ACTUAL_SMOOTHIE,smooth)
    }

    fun getActualSmoothie():Smooth{
        return if(Hawk.contains(ACTUAL_SMOOTHIE)){
            Hawk.get(ACTUAL_SMOOTHIE)
        }else{
            Smooth()
        }
    }

    fun setActualCategory(category: Category){
        Hawk.put(ACTUAL_CATEGORY,category)
    }

    fun getActualCategory():Category{
        return if(Hawk.contains(ACTUAL_CATEGORY)){
            Hawk.get(ACTUAL_CATEGORY)
        }else{
            Category()
        }
    }
}