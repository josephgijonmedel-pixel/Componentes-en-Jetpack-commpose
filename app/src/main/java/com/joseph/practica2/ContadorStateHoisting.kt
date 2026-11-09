package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ContadorStateHoisting(
    aumentar: Int,
    onIncrementar: () -> Unit,
    onDisminuir: ()  -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aumentar.toString(),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onIncrementar,
                    enabled = if (aumentar == 10) false else true
                ) {
                    Text(text = "Aumentar")
                }

                Button(
                    onClick = onDisminuir,
                    enabled = if (aumentar == 0) false else true
                ) {
                    Text(text = "Disminuir")
                }
            }
        }

    }


}

@Composable
fun PantallaPrincipal() {
    var contador by rememberSaveable() { mutableStateOf(0) }

    ContadorStateHoisting(
        aumentar = contador,
        onIncrementar = { contador++ },
        onDisminuir = { contador-- }
    )
}