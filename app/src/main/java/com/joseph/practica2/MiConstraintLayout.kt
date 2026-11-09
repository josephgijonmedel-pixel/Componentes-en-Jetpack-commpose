package com.joseph.practica2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun MiConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val (image, name, description, button) = createRefs()//crea referencias unicas para cada componente dentro del constrait layout
        //constraintAs() Vincula un componente a una referencia previamente creada y establece las restrincciones para posicionarlo

        Image(
            painter = painterResource(id = R.drawable.gato),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(100.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)//la parte sup. de la img, se alineara con la parte sup. del contenedor
                    start.linkTo(parent.start)//la parte izq. de la img, se alineara con el borde izq. del contenedor
                },
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Joseph Joel",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 16.dp)
                }
        )
        Text(
            text = "Android developer",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(name.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Button(
            onClick = {},
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(description.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(text = "Seguir")
        }
    }
}

@Composable
fun BotonAlCentro() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val button1 = createRef()

        Button(onClick = {},
            modifier = Modifier.constrainAs(button1){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Text(text = "Hola")
        }
    }
}