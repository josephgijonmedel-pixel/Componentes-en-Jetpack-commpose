package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//CHECKBOX: casilla de verificacion
/*Es un componente interactivo que permite al usuario selecconar una opcion binaria
activado(checked), desactivado(unChecked)*/
/*
Propiedades
checked: Estado si el checkbos esta macado (true) o no (false)
onValueChange : Lambda que se ejecuta cuando el estado del checkbox cambia
modifier: Permite modificar el estilo o comportamiento(tamaño, padding, etc)
enabled: Controla si el checkbox esta habilitado o deshabilitado
interactionSource: Fuente de interacciones como (hover, focus, etc.)
colors: Define los colores del checkbox mediante ChecknoxDefaults.colors()
*/

@Composable
fun MiCheckboxExample() {

    var accepted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Checkbox(
                checked = accepted,
                onCheckedChange = { accepted = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,//color cuando el checkbox esta marcado
                    uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,//color cuando el checkbos esta desmarcado
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary//color cuando de la palomita del checkbox
                )
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (accepted) "Acepatdo" else "Aceptar los terminos y condiciones")
        }

    }
}

@Composable
fun PreferencesApp() {

    val options = listOf(
        "Notificaciones por correo",
        "Notificaciones push",
        "Ofertas especiales",
        "Novedades del blog"
    )
    /*mutableStateMapOf significa que este mapa puede cambiar (se puede modificar).
    .apply es como decir: "Y ahora voy a trabajar con este mapa".*/
    val stateOptions = remember {
        mutableStateMapOf<String, Boolean>().apply {/*La primera columna guarda el nombre de la opción (texto).La segunda columna guarda si está activada o no (verdadero/falso).*/
            options.forEach {//recorre cada opcion de la lista
                put(it, false)//Agrega cada opcion al mapa con el valor false
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Seleccione tus preferencias",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(options) { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Checkbox(
                        checked = stateOptions[option] == true,
                        onCheckedChange = { stateOptions[option] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colorScheme.primary,
                            checkmarkColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = option)
                }

            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        val selected = stateOptions.filter { it.value }.keys

        Text(
            text = "Seleccionadas: ${if (selected.isEmpty()) "Ninguna" else selected.joinToString()}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}