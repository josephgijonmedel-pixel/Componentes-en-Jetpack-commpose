package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

//Propiedades
/*
value = Texto actual que se muestar en el campo
onValuechange = Callback que se ejecuta cuando el texto cambia
label = Etiqueta flotante que aparece dentro del campo
placeholder = Texto gris que se muestra como sugerencia
leadingIcon = Icono al inicio del campo de texto
trailingIcon = Icono al final del capo de texto(ideal para mostrar estado o accion)
singleLine = Si es TRUE, limita el campo a una sola linea
maxlines = Numero maximo de lineas permitidas
isError = si es TRUE, el campo se marca como erroneo(borde rojo, etc.)
keyboardsActions = Define las acciones que ocurren, ej: cuando se presiona "Enter" u otra opcion
visualTransformation = transformacion visual(ej: oculatr texto como en las contraseñas)
enabled = si es false, el campo esta deshabilitado
readOndly = Si es TRUE, el campo no se puede modificar, pero permite seleccion
*/
@Composable
fun MyOutlinedTextField() {

    var text by remember { mutableStateOf("") }
    val isError = text.length >= 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Nombre") },
            placeholder = { Text(text = "Ingresa tu nombre") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icono person"
                )
            },
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Icono warning"
                    )
                }
            },
            isError = isError,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(//indica que altera ciertass propiedades del teclado
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),//esquinas del campo de texto redondeadas
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,//color del borde cuando el campo de texto esta enfocado
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,//color del borde cuando el campo de texto no esta enfocaco
                errorBorderColor = MaterialTheme.colorScheme.error,//color cuando el estado es de error
                focusedLabelColor = MaterialTheme.colorScheme.primary,//Color cuando la etiqueta esta enfocada
                errorLabelColor = MaterialTheme.colorScheme.error//color de la etiqueta en error
            )

        )
        if (isError) {
            Text(
                text = "Maximo 10 caracteres",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(
                    start = 16.dp, top = 5.dp
                )
            )
        }

    }
}