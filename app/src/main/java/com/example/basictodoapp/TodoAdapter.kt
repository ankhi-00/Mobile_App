package com.example.basictodoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basictodoapp.databinding.TodoItemBinding

class TodoAdapter(
    private val todos: MutableList<Todo>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // Removed the onEditClick method from the interface
    interface OnItemClickListener {
        fun onDeleteClick(position: Int)
    }

    inner class TodoViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todos[position]
        holder.binding.apply {
            tvTodoTitle.text = currentTodo.title
            cbDone.isChecked = currentTodo.isChecked

            // Changed btnDelete to ivDelete to match your XML
            ivDelete.setOnClickListener {
                clickListener.onDeleteClick(position)
            }
            // Removed the btnEdit listener
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}