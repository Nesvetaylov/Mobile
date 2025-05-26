package com.example.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MAViewModel : ViewModel() {
    val users = MutableLiveData<MutableList<User>>(mutableListOf())
    var currentIndex =0
    fun moveToNext(){
        val currentList = users.value ?: mutableListOf()
        if (currentList.isNotEmpty()) {
            currentIndex = (currentIndex + 1) % currentList.size
        }
    }
    fun moveToPrev(){
        val currentList = users.value ?: mutableListOf()
        if (currentList.isNotEmpty()) {
            currentIndex = (currentIndex - 1 + currentList.size) % currentList.size
        }
    }
    fun NewUser(user: User){
        val currentList = users.value ?: mutableListOf()
        currentList.add(user)
        users.value = currentList
        currentIndex = currentList.size - 1
    }
    fun ChangeUser(index :Int,user: User){
        val currentList = users.value ?: mutableListOf()
        if (index >= 0 && index < currentList.size) {
            currentList[index] = user
            users.value = currentList
        }
    }
    fun getUser(): User? {
        val currentList = users.value ?: mutableListOf()
        if (currentList.isNotEmpty() && currentIndex >= 0 && currentIndex < currentList.size) {
            return currentList[currentIndex]
        }
        return null
    }
    fun cout(): String{
        return users.toString()
    }
}


