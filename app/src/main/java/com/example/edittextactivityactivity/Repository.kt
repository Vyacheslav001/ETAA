package com.example.edittextactivityactivity

class Repository {

//    var text1 =""
//    var text2 =""
//    var text3 =""

    val list: ArrayList<String> = arrayListOf("", "", "")

//    private val list1: MutableList<String> = mutableListOf(text1, text2, text3)

    fun getData() = list

    fun addData(element: String) {
        list.add(element)
    }

}