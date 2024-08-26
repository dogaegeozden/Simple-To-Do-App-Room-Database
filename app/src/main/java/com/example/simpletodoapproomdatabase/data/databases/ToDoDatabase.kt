package com.example.simpletodoapproomdatabase.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.simpletodoapproomdatabase.data.models.ToDo

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(Converters::class)
abstract class ToDoDatabase : RoomDatabase() {

    companion object {
        const val NAME = "ToDo_DB"
    }

    abstract fun getToDoDao() : ToDoDao
}