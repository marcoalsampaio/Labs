package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Boas Vindas", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Boas Vindas", Toast.LENGTH_LONG).show()
    }

    fun total(view: View) {
        val edt1 = findViewById<TextView>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val tv = findViewById<TextView>(R.id.tv)
        val cb = findViewById<CheckBox>(R.id.cb)
        if (cb.isChecked){
            var total =  edt1.text.toString().toInt() * edt2.text.toString().toInt() * 1.23;
            tv.text = total.toString();
        }else{
            var total =  edt1.text.toString().toInt() * edt2.text.toString().toInt();
            tv.text = total.toString();
        }


    }
}