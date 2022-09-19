package com.example.edittextactivityactivity

import android.app.Activity
import android.content.Intent

fun Activity.replaceActivity(activity: Activity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
}

