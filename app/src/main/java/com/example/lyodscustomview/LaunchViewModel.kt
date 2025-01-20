package com.example.lyodscustomview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LaunchViewModel : ViewModel() {

    var count = 0

    val newsData = MutableLiveData<String>("this is CURRENT NEWS")

    fun increment(){
        count ++
    }

    fun updateNews(){
        newsData.value = "this is UPDATED NEWS"
    }
}