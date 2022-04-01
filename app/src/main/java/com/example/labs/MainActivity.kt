package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Desafios
    }

    fun addToList(view: View) {
        val editTextNome = findViewById<EditText>(R.id.editTextNome)
        val editTextIdade = findViewById<EditText>(R.id.editTextIdade)
        val genero = findViewById<RadioGroup>(R.id.radioGroupGenero)
        val radioButton = findViewById<RadioButton>(genero.checkedRadioButtonId)
       // Toast.makeText(this, radioButton.text, Toast.LENGTH_LONG ).show()
    }
    fun goToList(view: View) {}
}