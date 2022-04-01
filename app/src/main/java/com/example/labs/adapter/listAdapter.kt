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

}

class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val nome = itemView.findViewById<EditText>(R.id.textViewNome);
    val idade = itemView.findViewById<EditText>(R.id.textViewIdade);
    val genero = itemView.findViewById<EditText>(R.id.textViewGenero);
}


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) { //Aceder a cada item, e colocar conteudo nas views criadas
        //Aceder ao item atual
        val currentTodo = todos[position]
        holder.title.text = currentTodo.title
        holder.date.text = currentTodo.date.toString()
        holder.number.text = "#"+(position+1).toString()
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(todo: Todo){
        todos.add(todo)
        notifyDataSetChanged()
    }
}

