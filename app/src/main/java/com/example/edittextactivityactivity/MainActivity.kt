package com.example.edittextactivityactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.edittextactivityactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = Repository()
    private val listTexts = repository.getData()
    private var preference: SharedPreferences? = null
//    private var text1 = repository.text1
//    private var text2 = repository.text2
//    private var text3 = repository.text3

    companion object {
        const val KEY_1 = "item1"
        const val KEY_2 = "item2"
        const val KEY_3 = "item3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView1 = binding.xTextView1
        val textView2 = binding.xTextView2
        val textView3 = binding.xTextView3
        val listTextViews = listOf(textView1, textView2, textView3)

        preference = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        repository.list[0] = preference?.getString("0", "")!!
        repository.list[1] = preference?.getString("1", "")!!
        repository.list[2] = preference?.getString("2", "")!!
//        textView1.text = repository.list[0]
//        textView2.text = repository.list[1]
//        textView3.text = repository.list[2]

//        listTexts[0] = preference?.getString("0", "")!!
//        listTexts[1] = preference?.getString("1", "")!!
//        listTexts[2] = preference?.getString("2", "")!!
//        textView1.text = listTexts[0]
//        textView2.text = listTexts[1]
//        textView3.text = listTexts[2]

//        repository.text1 = preference?.getString("0", "")!!
//        repository.text2 = preference?.getString("1", "")!!
//        repository.text3 = preference?.getString("2", "")!!
//        textView1.text = repository.text1
//        textView2.text = repository.text2
//        textView3.text = repository.text3

//        setText(listTextViews)
        toEditText(repository.list)
        getText(listTextViews)
//        setText(listTextViews)
    }

    private fun setText(list: List<TextView>) {
        list[0].text = repository.list[0]
        list[1].text = repository.list[1]
        list[2].text = repository.list[2]


//        list.forEachIndexed() { index, itTextView ->
//            itTextView.text = repository.list[index]
//        }

//        if (repository.list.isNotEmpty()) {
//            list.forEachIndexed() { index, itTextView ->
//                if (repository.list[index].isNotEmpty()) {
//                    itTextView.text = repository.list[index]
//                }
//            }
//        } else {
//            list.forEach {
//                repository.list.add("")
//                it.text = ""
//            }
//        }
    }

    private fun dataTransmission(list: MutableList<String>, index: Int, keyItem: String) {
        val intent = Intent(this@MainActivity, ItemActivity::class.java)
        intent.putExtra(index.toString(), index)
        if (list[index].isEmpty()) {
            intent.putExtra(keyItem, "")
        } else {
            intent.putExtra(keyItem, list[index])
        }
        startActivity(intent)
    }

    private fun toEditText(list: ArrayList<String>) {
        binding.xTextView1.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("0", 0)
            if (list[0].isEmpty()) {
                intent.putExtra("item1", "")
            } else {
                intent.putExtra("item1", list[0])
            }
            startActivity(intent)
        }
        binding.xTextView2.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("1", 1)
            if (list[1].isEmpty()) {
                intent.putExtra("item2", "")
            } else {
                intent.putExtra("item2", list[1])
            }
            startActivity(intent)
        }
        binding.xTextView3.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemActivity::class.java)
            intent.putExtra("2", 2)
            if (list[2].isEmpty()) {
                intent.putExtra("item3", "")
            } else {
                intent.putExtra("item3", list[2])
            }
            startActivity(intent)
        }


//        with(binding) {
//            xTextView1.setOnClickListener {
//                dataTransmission(list, 0, KEY_1)
//            }
//            xTextView2.setOnClickListener {
//                dataTransmission(list, 1, KEY_2)
//            }
//            xTextView3.setOnClickListener {
//                dataTransmission(list, 2, KEY_3)
//            }
//        }
    }

    private fun saveData(key: Int, text: String) {
        val editor = preference?.edit()
        editor?.putString(key.toString(), text)
        editor?.apply()
    }

    private fun getText(list: List<TextView>) {
        val key = intent.extras?.getInt(ItemActivity.KEY)
        val text = intent.extras?.getString(ItemActivity.KEY_FOR_TEXT)
        if (text != null && key != null) {
//            repository.list.add(key, text)
            repository.list[key] = text
            saveData(key, text)
        }
        setText(list)
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


//private fun toEditText(list: MutableList<String>) {
//    binding.xTextView1.setOnClickListener {
//        val intent = Intent(this@MainActivity, ItemActivity::class.java)
//        intent.putExtra("0", 0)
//        if (list[0].isEmpty()){
//            intent.putExtra("item1", "")
//        } else {
//            intent.putExtra("item1", list[0])
//        }
//        startActivity(intent)
//    }
//    binding.xTextView2.setOnClickListener {
//        val intent = Intent(this@MainActivity, ItemActivity::class.java)
//        intent.putExtra("1", 1)
//        if (list[1].isEmpty()){
//            intent.putExtra("item2", "")
//        } else {
//            intent.putExtra("item2", list[1])
//        }
//        startActivity(intent)
//    }
//    binding.xTextView3.setOnClickListener {
//        val intent = Intent(this@MainActivity, ItemActivity::class.java)
//        intent.putExtra("2", 2)
//        if (list[2].isEmpty()){
//            intent.putExtra("item3", "")
//        } else {
//            intent.putExtra("item3", list[2])
//        }
//        startActivity(intent)
//    }
//}