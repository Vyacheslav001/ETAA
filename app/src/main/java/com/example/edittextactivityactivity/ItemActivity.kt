package com.example.edittextactivityactivity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.edittextactivityactivity.databinding.ActivityItemBinding

//Ali+Enter -> добавить activity в manifest
class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding
    private val keys = listOf(0, 1, 2)
    private val keysItem = listOf("item1", "item2", "item3")
    var textItem = ""

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.xEditText

        keys.forEach { itKey ->
            if (itKey == intent.extras?.getInt(itKey.toString())){
                textItem = intent.extras?.getString(keysItem[itKey]).toString()



                binding.xEditText.setText(textItem)
                binding.xTextView.text = keysItem[itKey]
                binding.xButton.setOnClickListener {
                    val text = editText.text.toString()
                    val intent = Intent(this, MainActivity::class.java)
                    val index: Int = itKey
                    intent.putExtra("Item", index)
                    intent.putExtra("Key", text)
                    onToast(applicationContext, text)
//                    Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }
            }
        }
    }

    private fun editText() {

    }
}