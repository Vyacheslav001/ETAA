package com.example.edittextactivityactivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.edittextactivityactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = Repository()

    //    private val listTexts = mutableListOf("1", "2", "3")
//    private val listTexts: MutableList<String> = mutableListOf("", "", "")
    private lateinit var listTexts: MutableList<String>
    private val keys = listOf("0", "1", "2")
    private val keysItem = listOf("item1", "item2", "item3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        listTexts = mutableListOf("", "", "")
//        listTexts = mutableListOf()
        listTexts = repository.getData()
        val textView1 = binding.xTextView1
        val textView2 = binding.xTextView2
        val textView3 = binding.xTextView3
        val listTextView = listOf(textView1, textView2, textView3)

        setText(listTextView)
        toEditText(listTexts)
        getText(listTextView)
        setText(listTextView)
    }

    private fun setText(list: List<TextView>) {
//        if (list.isNullOrEmpty()) {
//            list.forEach {
//                it.text = ""
//            }
//        } else

//        list.forEachIndexed() { index, itTextView ->
//            itTextView.text = listTexts[index]
//        }

        if (listTexts.isNotEmpty()) {
            list.forEachIndexed() { index, itTextView ->
                if (listTexts[index].isNotEmpty()) {
                    itTextView.text = listTexts[index]
//                } else {
//                    listTexts.add("")
//                    itTextView.text = ""
                }
            }
        } else {
            list.forEach {
                listTexts.add("")
                it.text = ""
            }
        }
    }

    private fun toEditText(list: MutableList<String>) {
        binding.xTextView1.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("0", 0)
            if (list[0].isEmpty()){
                intent.putExtra("item1", "")
            } else {
                intent.putExtra("item1", list[0])
            }
            startActivity(intent)
        }
        binding.xTextView2.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("1", 1)
            if (list[1].isEmpty()){
                intent.putExtra("item2", "")
            } else {
                intent.putExtra("item2", list[1])
            }
            startActivity(intent)
        }
        binding.xTextView3.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("2", 2)
            if (list[2].isEmpty()){
                intent.putExtra("item3", "")
            } else {
                intent.putExtra("item3", list[2])
            }
            startActivity(intent)
        }
    }

    private fun getText(list: List<TextView>) {
        val text = intent.extras?.getString("Key")
        val key = intent.extras?.getInt("Item")
        if (text != null && key != null) {
            listTexts.add(key, text)
//            listTexts[key] = text
        }
//        setText(list)
    }
}


//    private fun getText(list: List<TextView>) {
//        keys.forEachIndexed() { index, it ->
//            val text = intent.extras?.getString(it)
//            if (text != null) {
//                listTexts[index] = text
//            }
//            setText(list)
//        }
//    }
