package com.example.edittextactivityactivity

import android.content.Context
import android.widget.Toast

fun onToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}