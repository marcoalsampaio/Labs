package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message = intent.getStringExtra(PARAM_1)
        val textView = findViewById<TextView>(R.id.newActivityTextView).apply {
            text = message
        }



    }
}