package com.joseph.practica2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/*
SCAFFOLD
Es un composable de alto nivel que proporciona una esttructura de base visual y de navegacion
para una pantalla en jetpack compose.
Calcula y aplica el espaciado automatico(padding) para que los elementos no se superpongan.
Organiza los componentes mas comunes:

-TopAppBar(Barra superior)
-BottomAppBar(Barra inferior de acciones)
-BottomNavigation(Barra inferior de navegacion)
-FloatingActionButton(Boton flotante)
-Drawer(Panel lateral)
-Content(Contenido principal)

PROPIEDADES PRINCIPALES
topBar (commposable para la barra superior)
bottomBar (composable para la barra inferior)
floatingActionButton (Boton de accion flotante)
floatingActionButtonPosition (posicion del boton flotante)
containerColor (Color de fondo de todo el contenido del scaffold)
contentColor (color aplicado al contenido dentro del scaffold(texto, iconos, etc))
drawerContent (Contenido del menu lateral(Navigation Drawer))
content (Contenido principal, donde se ajusta el padding automaticamente)
*/

@Composable
fun MiScaffold() {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        content = {
            //Contenido principal
            paddingValues ->
            Box(modifier = Modifier.fillMaxSize()
                .padding(paddingValues),
                contentAlignment = Alignment.Center
                ){
                Text(text = "Contenido principal")
            }
        }
    )
}