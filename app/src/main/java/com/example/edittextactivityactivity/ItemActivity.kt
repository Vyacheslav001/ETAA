package com.example.edittextactivityactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edittextactivityactivity.databinding.ActivityItemBinding

//Ali+Enter -> добавить activity в manifest
//android:inputType="textEmailAddress|textNoSuggestions" устраняет ошибку SPAN_EXCLUSIVE_EXCLUSIVE spans cannot have a zero length в activity_item.xml
class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding
    private val keys = listOf(0, 1, 2)
    private val keysItem = listOf("item1", "item2", "item3")

    companion object{
        const val KEY = "NumberOfItem"
        const val KEY_FOR_TEXT = "KeyForText"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        keys.forEach { itKey ->
            if (itKey == intent.extras?.getInt(itKey.toString())) {
                with(binding) {
                    val textItem = intent.extras?.getString(keysItem[itKey]).toString()
                    val editText = binding.xEditText
                    editText.setText(textItem)
                    xTextView.text = keysItem[itKey]
                    xButtonAdd.setOnClickListener {
                        val text = editText.text.toString()
                        val intent = Intent(this@ItemActivity, MainActivity::class.java)
                        intent.putExtra(KEY, itKey)
                        intent.putExtra(KEY_FOR_TEXT, text)
                        onToast(applicationContext, text)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}


//keys.forEach { itKey ->
//    if (itKey == intent.extras?.getInt(itKey.toString())) {
//        with(binding) {
//            textItem = intent.extras?.getString(keysItem[itKey]).toString()
//            val editText = binding.xEditText
//            editText.setText(textItem)
//            xTextView.text = keysItem[itKey]
//            xButton.setOnClickListener {
//                val text = editText.text.toString()
//                val intent = Intent(this@ItemActivity, com.example.edittextactivityactivity.MainActivity::class.java)
//                val index: Int = itKey
//                intent.putExtra("Item", index)
//                intent.putExtra("Key", text)
//                onToast(applicationContext, text)
//                startActivity(intent)
//            }
//        }
//
//    }
//}