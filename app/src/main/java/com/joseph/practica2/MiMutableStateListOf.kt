package com.joseph.practica2

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*Lista observable y mutable que notifica a Jetpck compose cuando su contenido cambia,
Lo que permite que la interfaz de usuario se recomponga de manera eficiente a esos cambios.*/


@Composable
fun MyMutableStateListOf() {

    val itemList = remember{mutableStateListOf("item 1", "item 2", "item 3") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { itemList.add("item ${itemList.size + 1}") })
        {
            Text(text = "Agregar item")
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn{
            items(itemList){
                item ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = item, style = MaterialTheme.typography.bodyLarge)
                        IconButton(onClick = {itemList.remove(item)}) {
                            Icon(
                                Icons.Default.Delete, contentDescription = "Eliminar"
                            )
                        }
                    }
                }
            }
        }
    }

}