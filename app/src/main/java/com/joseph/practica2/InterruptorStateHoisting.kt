package com.joseph.practica2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Interruptor(
    esColorNegro: Boolean,
    onCambiarModo: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (esColorNegro) Color.Black else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Modo oscuro",
            color = if (esColorNegro) Color.White else Color.Black
        )

        Button(onClick = onCambiarModo) {
            Text(text = if (esColorNegro) "Desactivar" else "Activar")
        }
    }
}

@Composable
fun PantallaInterruptor() {
    var esColorNegro by rememberSaveable() { mutableStateOf(false) }

    Interruptor(
        esColorNegro = esColorNegro,
        onCambiarModo = { esColorNegro = !esColorNegro }
    )

}