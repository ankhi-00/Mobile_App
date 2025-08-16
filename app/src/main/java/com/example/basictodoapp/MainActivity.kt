package com.example.basictodoapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basictodoapp.databinding.ActivityMainBinding
import com.example.basictodoapp.TodoAdapter.OnItemClickListener

class MainActivity : AppCompatActivity(), TodoAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    private var todoList = mutableListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the adapter with the list and the click listener
        todoAdapter = TodoAdapter(todoList, this)

        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val todoTitle = binding.etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoList.add(todo)
                todoAdapter.notifyItemInserted(todoList.size - 1)
                binding.etTodoTitle.text.clear()
            }
        }
    }

    override fun onDeleteClick(position: Int) {
        todoList.removeAt(position)
        todoAdapter.notifyItemRemoved(position)
    }


}