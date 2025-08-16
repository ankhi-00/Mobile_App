package com.example.basictodoapp

data class Todo(
    var title: String,
    var isChecked: Boolean = false // You can add other properties as needed
)