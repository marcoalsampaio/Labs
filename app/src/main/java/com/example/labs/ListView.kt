package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.adapter.ListAdapter

class ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.adapter = listAdapter
        rvItems.layoutManager = LinearLayoutManager(this)
    }

    fun deleteSelected(view: View) {}

}