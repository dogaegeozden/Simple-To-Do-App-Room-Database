package com.example.simpletodoapproomdatabase.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodoapproomdatabase.data.models.ToDo
import com.example.simpletodoapproomdatabase.ui.components.ToDoItem
import com.example.simpletodoapproomdatabase.ui.components.TopAppBar
import com.example.simpletodoapproomdatabase.ui.viewmodels.ToDoViewModel

@Composable
fun MainScreen(viewModel: ToDoViewModel){

    val toDoList by viewModel.toDoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
    ) {

        TopAppBar()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ){

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                onValueChange = {
                    inputText = it
                }
            )

            Spacer(modifier = Modifier.width(16.dp)) // Add space between elements

            Button(
                onClick = {
                    viewModel.addToDo(inputText)
                    inputText = ""
                }
            ) {
                Text(text="Add")
            }

        }

        toDoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){index: Int, item: ToDo ->
                        ToDoItem(
                            item = item,
                            viewModel,
                        )
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet",
            fontSize = 16.sp
        )

    }

}

