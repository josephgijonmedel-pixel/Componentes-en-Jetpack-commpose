package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MiLazyColumn2(listaFrutas: List<String>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Lista de frutas",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 35.sp,
                )
            }
            items(listaFrutas) { fruta ->
                Text(
                    text = fruta,
                    fontSize = 30.sp
                )
            }
        }


    }

}

@Composable
fun PantallaMiLazyColumn() {
    val listaFrutas = listOf("Manzana", "Pera", "Melon", "Uva", "Guaya")
    MiLazyColumn2(
        listaFrutas = listaFrutas
    )
}

@Composable
fun MiLazyRow() {

    val listaFrutas = listOf("Manzana ", "Pera ", "Melón ", "Uva ", "Guaya ")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Lista de frutas ",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.fillMaxWidth()
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(listaFrutas) { fruta ->
                    Text(
                        text = fruta,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Composable
fun LazyLazyColumn() {
    val itemList = List(100) { "Elemento N° ${it+1}" }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemList) { lista ->
            Text(text = lista, fontSize = 20.sp)
        }
    }
}