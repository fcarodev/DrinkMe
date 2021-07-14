package com.portfolio.drinkme.model

import android.content.res.ColorStateList
import com.portfolio.drinkme.utils.constants.UNDEFINED_STRING

data class Category(
    var id:String = UNDEFINED_STRING,
    var name:String = UNDEFINED_STRING,
    var imgUrl:String = UNDEFINED_STRING,
    var backgroundColor:String = UNDEFINED_STRING,
    var tintColor:String = UNDEFINED_STRING
)
