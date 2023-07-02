package com.example.itp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.input_field_1)
        val buttonSave: Button = findViewById(R.id.button1)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, todos)
        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)
            Toast.makeText(this, "Вы удалили из списка: $text", Toast.LENGTH_LONG).show()
        }

        buttonSave.setOnClickListener {
            var text = userData.text.toString().trim()
            if(text!="")
                adapter.insert(text, 0)
        }
    }
}