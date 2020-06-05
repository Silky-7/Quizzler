package com.silky.quizzler

data class Questions(
    val id:Int,
    val question: String,
    val image: Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctAns : Int
)