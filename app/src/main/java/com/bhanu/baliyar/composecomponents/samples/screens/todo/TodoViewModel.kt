package com.bhanu.baliyar.composecomponents.samples.screens.todo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    private val _todos = mutableStateListOf(
        TodoItem(1, "Buy groceries", false),
        TodoItem(2, "Walk the dog", false),
        TodoItem(3, "Call mom", false)
    )
    val todos: List<TodoItem> get() = _todos

    fun toggleTodo(id: Int, isCompleted: Boolean) {
        val index = _todos.indexOfFirst { it.id == id }
        if (index != -1) {
            _todos[index] = _todos[index].copy(isCompleted = isCompleted)
        }
    }

    fun deleteTodo(id: Int) {
        _todos.removeAll { it.id == id }
    }

    fun addTodo(text: String) {
        val nextId = (_todos.maxOfOrNull { it.id } ?: 0) + 1
        _todos.add(TodoItem(nextId, text, false))
    }
}