package com.example.simpletodoapproomdatabase.data.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.simpletodoapproomdatabase.data.models.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo ORDER BY createdAt DESC")
    fun getAllToDo() : LiveData<List<ToDo>>

    @Insert
    fun addToDo(toDo : ToDo)

    @Query("Delete FROM ToDo where id = :id")
    fun deleteToDo(id : Int)

    @Update
    fun updateToDo(toDo : ToDo)
}