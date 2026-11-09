package com.joseph.practica2

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerfilDeUsuario() {
    var seguirPerfil by remember { mutableStateOf(true) }
    var cantSeguidores = if (seguirPerfil) 223 else 224

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, Color.Black, shape = CircleShape),
                painter = painterResource(id = R.drawable.gato),
                contentDescription = "Perfil de usuario IMG"
            )
            Text(text = "GatoconOnd@_791")
            Text(
                text = "Biografía del gato con onda, jajajajaj",
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Publicaciones\n29",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Seguidores\n $cantSeguidores",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Seguidos\n15",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
            {
                Button(
                    onClick = { seguirPerfil = !seguirPerfil },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (seguirPerfil) Color(0xFF0095F6) else Color.Gray
                    )
                ) {
                    Text(
                        text = if (seguirPerfil) "Seguir" else "Seguido",
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                OutlinedButton(
                    onClick = {/**/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Enviar mensaje")
                }
            }
        }
    }
}