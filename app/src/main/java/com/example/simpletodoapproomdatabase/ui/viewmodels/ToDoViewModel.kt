package com.example.simpletodoapproomdatabase.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletodoapproomdatabase.MainApplication
import com.example.simpletodoapproomdatabase.data.models.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel : ViewModel() {

    val toDoDao = MainApplication.toDoDatabase.getToDoDao()

    val toDoList : LiveData<List<ToDo>> = toDoDao.getAllToDo()

    fun addToDo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.addToDo(ToDo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteToDo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.deleteToDo(id)
        }
    }

    fun updateToDo(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.updateToDo(toDo)
        }
    }
}