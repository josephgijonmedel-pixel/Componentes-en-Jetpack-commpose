package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*STATE HOISTING*/
//es un patrón de diseño en Jetpack Compose que consiste en mover el estado interno de un componente visual (composable) hacia su función contenedora o padre.

@Composable
fun MyStatehoisting(onTextChange: (String) -> Unit, text: String) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = "Escribe algo") },
        modifier = Modifier.fillMaxWidth()
    )
}
/*Padre*/
@Composable
fun PantallaMyStatehoisting() {
    var text by rememberSaveable{mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Hijo*/
        MyStatehoisting(text = text, onTextChange = {text = it})
    }
}

@Composable
fun MyScreen() {
    var isChecked by rememberSaveable{mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Modo oscuro: ${if (isChecked) "Activado" else "Desactivado"}")

        Spacer(modifier = Modifier.height(8.dp))

        MySwitch(
            checked = isChecked,//estado
            onCheckedChange = {isChecked = it}//La funcion que nos permitira actualizar el estado

        )
    }

}

@Composable
fun MySwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,///Activado
            uncheckedThumbColor = MaterialTheme.colorScheme.onSurface///Desactivado
        )
    )
}