package com.example.labs

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

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAdapter(ArrayList())
        //Desafios
        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        Log.d("RVITEMS", "$rvItems")
        //rvItems.adapter = listAdapter
       // rvItems.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val editTextNome = findViewById<EditText>(R.id.editTextNome).toString()
            val editTextIdade = findViewById<EditText>(R.id.editTextIdade).toString()

            val radioButton = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.radioGroupGenero).checkedRadioButtonId).toString()

            if(editTextIdade.isNotEmpty() && editTextNome.isNotEmpty() && radioButton.isNotEmpty()){
                val item = List(editTextNome, editTextIdade, radioButton)
                listAdapter.addItem(item)
                Toast.makeText(this, "Adicionado", Toast.LENGTH_LONG)
            }
        }

    }


    fun goToList(view: View) {

    }
}

