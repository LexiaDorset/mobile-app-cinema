package com.stu74526.lab2_74526

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

val backgroundColor = Color.Black
val textColor = Color.White
val contractTextColor = Color.LightGray
val contrastColor = Color.Gray
val selectedSeatColor = Color.Blue

val robotoFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)
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

@Composable

fun TextRoboto(text : String, color : Color, modifier : Modifier = Modifier, fontWeight: FontWeight = FontWeight.Normal,
               fontSize : TextUnit = 14.sp)
{
    Text(text = text, color = color,
        fontFamily = robotoFamily, fontWeight = fontWeight, fontSize = fontSize,
        modifier = modifier)
}
