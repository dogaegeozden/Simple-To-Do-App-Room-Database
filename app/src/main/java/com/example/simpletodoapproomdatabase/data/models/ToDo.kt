package com.example.simpletodoapproomdatabase.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * A data class to represent the To Do list items
 */
@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var createdAt: Date,
)