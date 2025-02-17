package com.example.task21

import androidx.lifecycle.ViewModel

class MainActivityViewModule:ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, true))

    private var currentIndex = 0
    //var isCheater

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestion: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        //isCheater=false
        currentIndex = (currentIndex+1)%questionBank.size
    }

    fun moveToPrev() {
        //isCheater = false
        currentIndex = (questionBank.size+currentIndex-1)%questionBank.size
    }
}