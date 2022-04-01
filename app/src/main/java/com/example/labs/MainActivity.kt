package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.models.List
import com.example.labs.adapter.ListAdapter
import java.io.Console
import java.util.zip.Inflater

lateinit var listAdapter: ListAdapter
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAdapter(ArrayList())

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val editTextNome = findViewById<EditText>(R.id.editTextNome).text.toString()
            val editTextIdade = findViewById<EditText>(R.id.editTextIdade).text.toString()
            val radioButton = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.radioGroupGenero).checkedRadioButtonId).text.toString()

            if(editTextIdade.isNotEmpty() && editTextNome.isNotEmpty() && radioButton.isNotEmpty()){
                val item = List(editTextNome, editTextIdade, radioButton)
                listAdapter.addItem(item)
            }
        }

    }

    fun goToList(view: View) {
        val intent = Intent(this, ListView::class.java)
        startActivity(intent)
    }
}

