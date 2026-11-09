package com.joseph.practica2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
fun AñadirElementoAListas() {
    var elementos = remember { mutableListOf("Uno", "Dos", "Tres", "Cuatro") }

    var textoIngresado by remember { mutableStateOf("") }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        , contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
            , verticalArrangement = Arrangement.spacedBy(8.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = elementos.joinToString(", "))

            OutlinedTextField(
                value = textoIngresado,
                onValueChange = {textoIngresado = it},
                label = {Text(text = "Añade algo a la lista")}
            )

            Button(
                onClick = {elementos.add(textoIngresado)
                    textoIngresado = ""},
            )
            { Text(text = "Aceptar")}
        }

    }
}