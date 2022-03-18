package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeName(view: View) {
        val nomeView = findViewById<TextView>(R.id.NomeView)
        val nomeEdit = findViewById<EditText>(R.id.NomeEdit)
        Toast.makeText(this, nomeEdit.text, Toast.LENGTH_LONG).show()
        nomeView.text = nomeEdit.text
    }
}