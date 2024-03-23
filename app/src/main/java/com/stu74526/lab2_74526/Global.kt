package com.stu74526.lab2_74526

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

val backgroundColor = Color.Black
val textColor = Color.White
val contractTextColor = Color.LightGray
val contrastColor = Color.Gray
val selectedSeatColor = Color.Blue

@Composable
fun ShowImage(
    draw: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = draw),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun ShowImageScale(
    draw: Int, modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillBounds
) {
    Image(
        painter = painterResource(id = draw),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}
