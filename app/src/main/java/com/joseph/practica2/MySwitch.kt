package com.joseph.practica2

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/*
SWITCH: Componente de contro que permite a los usuarios activar o desactivar una opcion, representando un estado binario(encendido/apagado, verdadero/falso)

Propiedades:
checked = Indica si esta activado(true) o desactivado(false)
onCheckedChange = Lambda que se llama cuando el usuario cambia el estado del switch
enabled = Controla si el Switch esta habilitado(true) o deshabilitado(false)
modifier = Permite aplicar modificaciones de deiseño como tamaño, padding, etc.
thumbContent = Permite personalizar el conteniddo dentro de "thumb" (el circulo que se mueve). Opcional.
colors = Permite personalizar los colores del Switch en diferentes estados, usando SwitchDefaults.colors()

*/
@Composable
fun MySwitchExample() {
    var wifiEnabled by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),//espaciado interno
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Wi-Fi",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = if (wifiEnabled) "Conectado" else "Wi-Fi desactivado",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = wifiEnabled,
                onCheckedChange = { wifiEnabled = it },
                thumbContent = {
                    if (wifiEnabled) {
                        Icon(
                            imageVector = Icons.Default.Check, contentDescription = "Activado",
                            tint = Color.White,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                    else{
                        Icon(imageVector = Icons.Default.Close,
                            contentDescription = "Desactivado",
                            tint = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(SwitchDefaults.IconSize))
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.surfaceVariant,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha =0.5f )
                )
            )
        }
    }
}