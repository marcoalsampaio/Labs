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

    private val todos =  ArrayList<Todo>(5);


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todos.add(Todo("Pais 10", "Capital 10", 10000, 100, 200))
        todos.add(Todo("Pais 9", "Capital 9", 9000, 90, 180))
        todos.add(Todo("Pais 8", "Capital 8", 8000, 80, 160))
        todos.add(Todo("Pais 7", "Capital 7", 7000, 70, 140))
        todos.add(Todo("Pais 6", "Capital 6", 6000, 60, 120))
        todos.add(Todo("Pais 5", "Capital 5", 5000, 50, 100))
        todos.add(Todo("Pais 4", "Capital 4", 4000, 40, 80))
        todos.add(Todo("Pais 3", "Capital 3", 3000, 30, 60))
        todos.add(Todo("Pais 2", "Capital 2", 2000, 20, 40))
        todos.add(Todo("Pais 1", "Capital 1", 1000, 10, 20))
        //todoAdapter = TodoAdapter(ArrayList()) //ArrayList vazio


        //rvTodoItems.adapter = todoAdapter
        //rvTodoItems.layoutManager = LinearLayoutManager(this)



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