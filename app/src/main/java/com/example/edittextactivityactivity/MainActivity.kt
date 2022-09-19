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
    private lateinit var listTextViews: List<TextView>
    private var preference: SharedPreferences? = null

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
        listTextViews = listOf(textView1, textView2, textView3)

        preference = getSharedPreferences("TABLE", Context.MODE_PRIVATE)

        getDataFromMemory(listTexts)
        toEditText(listTexts)
        getText(listTexts)
        onClickClearAll(listTexts, listTextViews)
        onClickDeleteItem(listTexts, listTextViews)
        setText(listTexts, listTextViews)
    }

    private fun getDataFromMemory(list: ArrayList<String>) {
        list.forEachIndexed { index, _ ->
            list[index] = preference?.getString(index.toString(), "")!!
        }
    }

    private fun setText(list: ArrayList<String>, listTV: List<TextView>) {
        listTV.forEachIndexed { index, it ->
            it.text = list[index]
        }
    }

    private fun dataTransmission(list: ArrayList<String>, indexOfItem: Int, keyItem: String) {
        val intent = Intent(this@MainActivity, ItemActivity::class.java)
        intent.putExtra(indexOfItem.toString(), indexOfItem)
        intent.putExtra(keyItem, list[indexOfItem])
        startActivity(intent)
    }

    private fun toEditText(list: ArrayList<String>) {
        with(binding) {
            xTextView1.setOnClickListener {
                dataTransmission(list, 0, KEY_1)
            }
            xTextView2.setOnClickListener {
                dataTransmission(list, 1, KEY_2)
            }
            xTextView3.setOnClickListener {
                dataTransmission(list, 2, KEY_3)
            }
        }
    }

    private fun saveData(key: Int, text: String) {
        val editor = preference?.edit()
        editor?.putString(key.toString(), text)
        editor?.apply()
    }


    private fun getText(list: ArrayList<String>) {
        val key = intent.extras?.getInt(ItemActivity.KEY)
        val text = intent.extras?.getString(ItemActivity.KEY_FOR_TEXT)
        if (text != null && key != null) {
            list[key] = text
            saveData(key, text)
        }
    }

    private fun onClickClearAll(list: ArrayList<String>, listTV: List<TextView>) {
        binding.xBtnClearAll.setOnClickListener {
            clearAll(list, listTV)
        }
    }

    private fun clearAll(list: ArrayList<String>, listTV: List<TextView>) {
        val editor = preference?.edit()
        editor?.clear()
        editor?.apply()
        list.forEachIndexed { index, _ ->
            list[index] = ""
        }
        listTV.forEach {
            it.text = ""
        }
    }

    private fun onClickDeleteItem(list: ArrayList<String>, listTV: List<TextView>) {
        with(binding) {
            xBtnDelItem1.setOnClickListener {
                deleteItem(list, listTV, 0)
            }
            xBtnDelItem2.setOnClickListener {
                deleteItem(list, listTV, 1)
            }
            xBtnDelItem3.setOnClickListener {
                deleteItem(list, listTV, 2)
            }
        }
    }

    private fun deleteItem(list: ArrayList<String>, listTV: List<TextView>, index: Int) {
        //index == key
        list[index] = ""
        listTV[index].text = ""
        val editor = preference?.edit()
        editor?.remove(index.toString())
        editor?.apply()
    }

    override fun onDestroy() {
//Стирание данных при закрытии приложения
//        clearAll(listTexts, listTextViews)
        super.onDestroy()
    }
}