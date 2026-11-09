package com.joseph.practica2

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/* Estados en jetpack compose
Son cualquier valor que puede cambiar con el tiempo y que se actualiza en la pantalla.
*/
//Cuando un estado cambia, Compose vuelve a ejecutar de forma automatica los elementos afectados a traves de un proceso llamado RECOMPOSICIÖN
//Compose se actualiza cada que la IU cambia de estado
//REMEMBER: Se utiliza para almacenar y conservar valores en la recomposicion, evitando que se reinicien cada vez que la UI se vuelve a dibujar
//RECOMPOSICIÖN: Es cuando el Composable se vuelve a ejecutar cuando el estado cambia. Actualizando las parts necesarias de la UI, sin reconstruir toda la jerarquia.

/*Cuando usar Remember: Cuando queremos que un valor se mantenga dentro de una recomposicion.
                        Para estados locales dentro de un composable
                        Si no requerimos compartir el estado entre varias pantallas
* */
@Composable
fun RememberExample() {

    var count by remember{ mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$count")
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick={count++}
        ){
            Text(text = "Incrementar")
        }
    }

}

@Composable
fun RememberSaveableExample() {

    var myName by rememberSaveable{mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingrese su nombre y luego gire su pantalla",
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value = myName,
            onValueChange = {myName = it},//actualiza la variable "myName" con el nuevo valor ingresado
            label = {Text(text = "ingresa tu nombre")},
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {myName = "" }//Al presionar el boton, la variable se vuelve un texto vacio
        ) {
            Text(text = "Borrar nombre")
        }

    }

}