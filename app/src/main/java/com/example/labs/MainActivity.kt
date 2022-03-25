package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs.adapters.TodoAdapter
import com.example.labs.models.Todo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate



class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter //lateinit para iniciar dps a variavel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(ArrayList()) //ArrayList vazio


        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)



        btnAddToDo.setOnClickListener {
            val todoTitle = editTextToDo.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle, LocalDate.now())

                todoAdapter.addTodo(todo)

                editTextToDo.text.clear()
            }
        }
    }
}