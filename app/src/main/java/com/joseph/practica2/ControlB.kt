package com.joseph.practica2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ControlB() {
    var buzzeEncendido by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = if (buzzeEncendido) Color.Green else Color.Red)
        , contentAlignment = Alignment.Center){
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (buzzeEncendido) "Estado: Encendido" else "Estado: Apgado",)

            Button(onClick = {buzzeEncendido = !buzzeEncendido})
            {
                Text(text = if (buzzeEncendido) "Apagar" else "Encender")
            }
        }
    }

}