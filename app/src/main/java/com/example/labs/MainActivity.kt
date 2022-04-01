package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val PARAM_1 = "PARAM_NAME"
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

    fun nextPage(view: View){
        val text = findViewById<EditText>(R.id.NomeEdit)
        val intent = Intent(this, MainActivity2::class.java).apply{
            putExtra(PARAM_1, text.text.toString())
        }
        startActivity(intent)
    }
}