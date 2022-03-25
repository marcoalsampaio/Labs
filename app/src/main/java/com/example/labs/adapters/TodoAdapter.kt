package com.example.labs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.models.Todo
import kotlinx.android.synthetic.main.todo_line.view.*

class TodoAdapter (
    private val todos: ArrayList<Todo>
        ): RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.todo_line,
                    parent,
                    false
                )
        )
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

class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){ //Representar o conteudo de uma lista, aceder as textviews etc etc..
    val title = itemView.todoTitle //Aceder ao viewHolder.title ...
    val date = itemView.todoDate
    val number = itemView.todoNum
}