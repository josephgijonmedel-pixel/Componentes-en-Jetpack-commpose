package com.joseph.practica2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


/*Componente de entrada de teto que permite
al usuario ingresar y editar texto*/

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
fun MyTextField() {

    var text by remember { mutableStateOf("") }
    val isError = text.length >= 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = text)

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Nombre") },
            placeholder = { Text(text = "Ingrese su nombre") },
            leadingIcon = {
                Icon(
                    Icons.Default.Person, contentDescription = "Icono person"
                )
            },
            trailingIcon = {
                if (isError) {
                    Icon(
                        Icons.Default.Warning,
                        contentDescription = "Icono warning",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            isError = isError,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,//cada palabra incia en mayuscula
                keyboardType = KeyboardType.Text,//tipo de teclado
                imeAction = ImeAction.Done,//Boton que va a aparecer en el teclado virtual
            ),
            keyboardActions = KeyboardActions(
                onDone = {/**/}
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (isError){
            Text(text = "Maximo 10 caracteres",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 5.dp))
        }
    }
}