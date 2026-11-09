package com.joseph.practica2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


/*

TOPAPPBAR
Es un componente de intergaz de usuario que representa una barra superiror en la aplicacion. Su prop
osito principal es mostrar informacion clave, como el tituli de la pantalla, y facilitar
la navegacion mediante acciones principales(como busqueda, menu, notificaciones, etc.)

PROPIEDADES
title = Composableque muestra el tituolo de la pantalla( generalmente un Text)
navigationIcon = Icono principal que suale representar el boton de navegacion(por ejemplo, menu o retroceso)
actions = Composable que agrupa acciones secundarias (iconos o botones) alineadas a la derechas.
colors = Permite definir los colores de fondo, icones y texto.
scrollBehavior = Controla como reacciona la barra al hacer scroll (por ejemplo, si se oculta, colpasa o permanece fija durante el desplazamiento
del usuario). (Uso avanzado).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopAppBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mi aplicación") },
                navigationIcon = {
                    IconButton(onClick = {/*Accion del menu*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {/*Accion de busqueda*/}) {
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "buscar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )

            )
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        content = {
            //Contenido principal
                paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Contenido principal")
            }
        }
    )
}