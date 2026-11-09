package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//Crea un estado derivado de otro, optimizando la recomposicion
//Su valor se actualiza solo cuando cambie el estado del que depende

@Composable
fun CounterScreen() {
    var count by rememberSaveable { mutableIntStateOf(0) }

    val esPar by remember { derivedStateOf { count % 2 == 0 } }//Par

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contador: $count")
        Text(text = if (esPar) "Es par" else "Es impar")
        Button(onClick = { count++ }) {
            Text(text = "Incrementar")
        }
    }
}

@Composable
fun MyDerivedState() {
    var text by rememberSaveable { mutableStateOf("") }

    val textColor by remember {
        derivedStateOf {
            if (text.length > 10) Color.Red else Color.Blue
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },//Actualiza el valor del textp
            label = {
                Text(text = "Escribe algo")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Longitud: ${text.length}",
            color = textColor,
            style = MaterialTheme.typography.headlineMedium)
    }

}