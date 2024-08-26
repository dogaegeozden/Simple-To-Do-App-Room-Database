package com.example.simpletodoapproomdatabase.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletodoapproomdatabase.R
import com.example.simpletodoapproomdatabase.data.models.ToDo
import com.example.simpletodoapproomdatabase.ui.viewmodels.ToDoViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ToDoItem(
    item: ToDo,
    viewModel: ToDoViewModel,
) {
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(item.title) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_edit_note_24),
                contentDescription = "Update",
                tint = Color.White,
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Update title") },
                singleLine = true,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = {
                    viewModel.updateToDo(ToDo(item.id, text, item.createdAt))
                    expanded = false
                },
                modifier = Modifier.padding(start=16.dp)
            ){
                Text("Save")
            }
        }

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray,
            )
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        IconButton(
            onClick = {
                viewModel.deleteToDo(item.id)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White,
            )
        }
    }
}