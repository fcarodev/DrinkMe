package com.portfolio.drinkme.model

import com.portfolio.drinkme.utils.constants.UNDEFINED_STRING

data class Smooth(
    var id:String = UNDEFINED_STRING,
    var userId:String = UNDEFINED_STRING,
    var name:String = UNDEFINED_STRING,
    var imgUrl:String = UNDEFINED_STRING,
    var description:String = UNDEFINED_STRING,
    var category:Category = Category(),
    var prepareTime:String = UNDEFINED_STRING,
    var isFavourite:Boolean = false,
    var ingredients:MutableList<String> = mutableListOf(),
    var instructions:MutableList<String> = mutableListOf(),
    var nutritions:MutableList<String> = mutableListOf()
)
