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
        holder.pais.text = currentTodo.pais
        if (currentTodo.habitantes.toInt()<200){
            holder.cidade.text = "Pequeno"
        }else if(200<=currentTodo.habitantes.toInt() && currentTodo.habitantes.toInt()<500){
            holder.cidade.text = "Medio"
        }else{
            holder.cidade.text = "Grande"
        }
      //  holder.cidade.text = currentTodo.capital
        holder.habitantes.text = currentTodo.habitantes.toString()
        holder.fregDis.text = (currentTodo.n_distritos * currentTodo.n_freguesias).toString()
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
    val pais = itemView.todoTitle //Aceder ao viewHolder.title ...
    val cidade = itemView.todoCidade
    val habitantes = itemView.todoHabitantes
    val fregDis = itemView.todoNFreg
}