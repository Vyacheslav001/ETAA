package com.example.edittextactivityactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*

fun Activity.replaceActivity(activity: Activity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
}

fun onToast(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}