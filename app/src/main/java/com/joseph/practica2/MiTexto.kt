package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
fun MiTexto() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Soy un texto",
            color = Color.Blue,//Color
            fontSize = 20.sp,//Tamaño
            fontWeight = FontWeight.Bold,//Grosor
            textAlign = TextAlign.Center//Alineacion
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Soy un texto",
            style = TextStyle(
                color = Color.Magenta,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )

        )
    }
}