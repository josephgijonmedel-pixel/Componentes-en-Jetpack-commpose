package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
Slider =
Es un control deslizante que permite al usuario elegir un valoe dentro de un rango continuo,
moviendo el pulgar(thumb) a lo largo de una pista(track). Se usa comunmente
para ajustar confuguraciones como volumen, brillo, zoom o cualquier valor numerico.

Propiedades
value = Valor actual del slider (entre valudeRange)
onValueChange = Callback que se ejecuta cuando el valor cambia
modifier = Permite modificar el relleno(padding) y otros aspectos visuales del slider
valueRange = Define el rango permitido del slider (por defecto 0f..1f)
steps = Cantidad de pasos intermedios opcionales entre los valores minimo y maximo
enabled = Controla si el slider esta habilitado para la interaccion del usuario
onValueChangeFinished = Callback que se ejecuta cuando el usuario finaliza la interaccion(suelta el dedo)
colors = Define los colores del componenete, como el pulgar, lapista activa o inactiva
*/

@Composable
fun MySliderExample() {
    var sliderValue by remember { mutableFloatStateOf(50f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Volumen actual: ${sliderValue.toInt()}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = sliderValue,
            onValueChange = {sliderValue = it},
            valueRange = 0f..100f,
            steps = 3,
            onValueChangeFinished = {
                println("El usuario solto el slider en: $sliderValue")
            },
            colors = SliderDefaults.colors(
                activeTickColor = MaterialTheme.colorScheme.primary,
                inactiveTickColor = MaterialTheme.colorScheme.surfaceVariant,
                thumbColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}