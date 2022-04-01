package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.models.List
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAdapter(ArrayList())
        //Desafios
        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.adapter = listAdapter
        rvItems.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val editTextNome = findViewById<EditText>(R.id.editTextNome).toString()
            val editTextIdade = findViewById<EditText>(R.id.editTextIdade).toString()
            val genero = findViewById<RadioGroup>(R.id.radioGroupGenero)
            val radioButton = findViewById<RadioButton>(genero.checkedRadioButtonId).toString()

            if(editTextIdade.isNotEmpty() && editTextNome.isNotEmpty() && radioButton.isNotEmpty()){
                val item = List(editTextNome, editTextIdade, radioButton)
            }
        }

    }


    fun goToList(view: View) {

    }
}

