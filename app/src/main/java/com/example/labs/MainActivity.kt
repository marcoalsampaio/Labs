package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //Criuar  menu e defenir o menu a apresentar
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //Case mediante o item id
        return when (item.itemId){
            R.id.create_new -> {
                Toast.makeText(this, "create_new", Toast.LENGTH_LONG).show()
                true
            }
            R.id.op1 -> {
                Toast.makeText(this, "Opcao 1", Toast.LENGTH_LONG).show()
                true
            }
            R.id.op2 -> {
                Toast.makeText(this, "Opcao 2", Toast.LENGTH_LONG).show()
                true
            }
            R.id.op3 -> {
                Toast.makeText(this, "Opcao 3", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}