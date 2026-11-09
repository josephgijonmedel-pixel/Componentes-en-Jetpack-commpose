package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
RadioButton:
componenete de seleccion unico que permite escoger una sola opcion dentro de un grupo de opciones.

PROPIEDADES
selected:Boolean = Indica si el RadioButton esta seleccionado o no. Es OBLIGATORIO
onClick:()-> Unit = Lambda que se ejecuta cuando cambia el estado del RadioButton
enabled:Boolean = Permita habilotar o deshabilitar el RadioButton. Valor por defecto: true
colors:RadioButtonColors = Permita perzonalizar los colores del boton en diferentes estados usando RadioButtonDefaults.colors()
modifier:Modifier = Permite modificar el layout(tamaño, padding y margen, etc.)
*/

@Composable
fun RadioButtonExample() {
    val options = listOf("Opcion A", "Opcion B", "Opcion C")

    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selecciona una opcion",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(options) { option ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                ) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = {selectedOption = option},
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colorScheme.primary,
                            unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            disabledSelectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                            disabledUnselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    Text(text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp))
                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Opcion seleccionada $selectedOption",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary)
    }

}