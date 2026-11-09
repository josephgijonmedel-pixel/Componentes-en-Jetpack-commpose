package com.joseph.practica2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Contador() {
    Box(modifier = Modifier.fillMaxSize()
        , contentAlignment = Alignment.Center
    ){
        var contador by remember { mutableStateOf(0) }

        OutlinedButton(
            onClick = {contador++},
        )
        {
            Text(text = contador.toString(),
                fontWeight = FontWeight.Bold)
        }
    }
}