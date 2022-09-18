package com.example.edittextactivityactivity

import android.widget.EditText

class Repository {

    private val list: MutableList<String> = mutableListOf()

    fun getData() = list

    fun addData(element: String){
        list.add(element)
    }

}