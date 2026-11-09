package com.joseph.practica2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp


@Composable
fun MiniFeed(
    onLikes: () -> Unit,
    inputText: String,
    onMostrarComentarios: () -> Unit,
    mostrarComentarios: Boolean,
    onComentario: (String) -> Unit,
    onGuardarComentario: () -> Unit,
    comentarioGuardado: String,
    cantLikes: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(start = 12.dp, top = 25.dp, bottom = 12.dp, end = 12.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(width = 2.dp, Color.Black)
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gato),
                        contentDescription = "PerfilUser"
                    )

                }
                Text(text = "@GatoConOnda_10. \n Hace 2 horas")

            }
            Text(
                "\"Soy el gato. El resto es ruido.\"",
                fontStyle = FontStyle.Italic
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                ) {
                    Image(
                        modifier = Modifier.size(250.dp),
                        painter = painterResource(id = R.drawable.gato2),
                        contentDescription = "publicacion"
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.corazon),
                        contentDescription = "CantLikes",
                        tint = Color.Red
                    )
                    Text(
                        text = "Me gusta $cantLikes ",
                        modifier = Modifier.clickable(onClick = onLikes)
                    )
                }

                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.comment),
                        contentDescription = "CantLikes",
                        tint = Color.White
                    )
                    Text(
                        text = "Comentar",
                        modifier = Modifier
                            .clickable(
                                onClick = onMostrarComentarios
                            )
                    )
                }
            }
            if (mostrarComentarios) {
                OutlinedTextField(
                    value = inputText,
                    onValueChange = onComentario,
                    label = { Text(text = "Deja tu comemtario") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = onGuardarComentario) { Text(text = "Subir") }
            }
            Box(){
                Text(comentarioGuardado)
            }


        }
    }
}

@Composable
fun PantallaMiniFeed() {
    var cantLikes by rememberSaveable() {mutableStateOf(12) }
    var likes by rememberSaveable() { mutableStateOf(false) }
    var mostrarComentarios by rememberSaveable() { mutableStateOf(false) }
    var inputText by rememberSaveable() { mutableStateOf("") }
    var comentarioGuardado by rememberSaveable() { mutableStateOf("") }
    var listaComentarios = rememberSaveable() { mutableListOf("")}
    MiniFeed(
        cantLikes = if (likes) cantLikes+1 else cantLikes,
        onLikes = { likes = !likes},
        inputText = inputText,
        mostrarComentarios = mostrarComentarios,
        onMostrarComentarios = { mostrarComentarios = !mostrarComentarios },
        onComentario = { inputText = it },
        onGuardarComentario = { comentarioGuardado = inputText },
        comentarioGuardado = comentarioGuardado
    )
}