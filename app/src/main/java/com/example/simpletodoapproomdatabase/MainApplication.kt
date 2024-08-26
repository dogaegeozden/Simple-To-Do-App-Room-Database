package com.example.simpletodoapproomdatabase

import android.app.Application
import androidx.room.Room
import com.example.simpletodoapproomdatabase.data.databases.ToDoDatabase

class MainApplication : Application() {
    companion object {
        lateinit var toDoDatabase : ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        toDoDatabase = Room.databaseBuilder(
            applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME
        ).build()
    }
}