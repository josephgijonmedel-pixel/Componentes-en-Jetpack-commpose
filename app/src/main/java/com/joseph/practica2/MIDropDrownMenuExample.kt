package com.joseph.practica2

import android.widget.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/*
MIDropDrownMenuExample
Es un componente de interfaz de usuario que muestra una lista desplegable de opcioness cuando el usuario
interactua con un disparador(generalmente un boton o icono)
El DorpdownMenu no es componenete visible por si mismo: depende de un control externo
(como un Button, IconButton,etc.) para mostrarse (expanded) y ocultarse(onDismissRequest)

Propiedades
expanded = Controla si el menu esta desplegado (true) o no (false)
onDismissRequest = Callback que se ejecuta cuando se debe cerrar el menu (por ejemplo, al hacer clic fuera)
modifier = Permite modificar el estilo o tamaño del menu.
offset = Permite desplazar la disposicion del menu respecto a su posicion origianal relativa al boton que lo activo.
properties = Personaliza el comportamiento de la ventana emergente, por ejemplo, deshabilitar el enfoque.
 */

@Composable
fun MIDropDrownMenuExample() {
    var expanded by remember { mutableStateOf(false) }

    var selectedOption by remember { mutableStateOf<Pair<String, ImageVector>?>(null) }

    val options = listOf(
        "Inicio" to Icons.Default.Home,
        "Favoritos" to Icons.Default.Favorite,
        "Configuración" to Icons.Default.Settings
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { expanded = true }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    selectedOption?.second?.let { icon ->
                        Icon(
                            imageVector = icon,
                            contentDescription = selectedOption?.first,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(
                        selectedOption?.first ?:"Selecciona una opcion" //?: significa "si el dato viene vacio"
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {expanded = false},
                offset = DpOffset(x = (-60).dp, y = 0.dp)//Mueve el menu desplegable, desde su posicion original
            ) {
                options.forEach {(text, icon) ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = text,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))

                                Text(text = text)
                            }
                        },
                        onClick = {
                            selectedOption = text to icon
                            expanded = false
                        }
                    )
                }
            }

        }
    }
}