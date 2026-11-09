package com.joseph.practica2

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

data class Contacto(val id: Int, val nombre: String, val estado: String)

@Composable
fun PracticaLazyColumn() {

    val listaContactos = listOf(
        Contacto(1, "Josep Joel", "En línea"),
        Contacto(2, "Alex Dev", "Ocupado"),
        Contacto(3, "María López", "En reunión"),
        Contacto(4, "Carlos Pérez", "Ausente"),
        Contacto(5, "Ana Gómez", "En línea"),
        Contacto(6, "Lucía Fernández", "En línea"),
        Contacto(7, "David Ruiz", "Desconectado")
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = "Contactos recientes",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
        items(
            items = listaContactos,
            key = { contacto -> contacto.id }
        ){
            contacto ->
            TarjetaContactItem(contacto)
        }
    }
}

@Composable
fun TarjetaContactItem(contacto: Contacto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)//Sombra
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = CircleShape//forma circualr
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contacto.nombre.take(1),//toma el primer caracter de l nombre (ej. G de Gijon)
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Column {
                Text(
                    text = contacto.nombre,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = contacto.estado,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}