package com.example.labs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.models.list

class listAdapter (private val list: ArrayList<list>): RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.list_line,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = list[position]
        holder.genero.text = currentItem.genero
        holder.nome.text = currentItem.name
        holder.idade.text = currentItem.genero.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItem(item: list){
        list.add(item)
        notifyDataSetChanged()
    }
}

class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val nome = itemView.findViewById<EditText>(R.id.textViewNome);
    val idade = itemView.findViewById<EditText>(R.id.textViewIdade);
    val genero = itemView.findViewById<EditText>(R.id.textViewGenero);
}


