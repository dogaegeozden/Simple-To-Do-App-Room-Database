package com.example.simpletodoapproomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.simpletodoapproomdatabase.ui.screens.MainScreen
import com.example.simpletodoapproomdatabase.ui.theme.SimpleToDoAppRoomDatabaseTheme
import com.example.simpletodoapproomdatabase.ui.viewmodels.ToDoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        setContent {
            SimpleToDoAppRoomDatabaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(toDoViewModel)
                }
            }
        }
    }
}
