package com.stu74526.lab2_74526

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        MainHome(navController)
    }
}

@Composable
fun MainHome(navController: NavController) // Main function of Home page
{
    BoxText(
        "Home Page Movie App 74526", textColor, Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .border(0.dp, contrastColor, RoundedCornerShape(0.dp))
    )
    Body(navController)
}

@Composable
fun Body(navController: NavController) // Body with credit of Home page
{
    Column(modifier = Modifier.fillMaxSize()) {
        MovieList(navController)
        BoxText(
            "Credits: http://www.impawards.com/ & https://www.imdb.com/",
            textColor, Modifier
                .fillMaxWidth()
                .background(
                    backgroundColor
                )
        )
    }
}

@Composable
fun MovieList(navController: NavController) // List of movies
{
    for (i in movies.indices) {
        MovieCard(movies[i], navController)
    }
}

@Composable
fun BoxText(textString: String, textColor: Color, modifier: Modifier = Modifier) // Text in a box
{
    Box(modifier = modifier, contentAlignment = Alignment.Center)
    {
        TextRoboto(text = textString, color = textColor)
    }
}

@Composable
fun MovieCard(movie: Movie, navController: NavController) // Card of a movie
{
    Button(
        onClick = {
            navController.navigate(
                Routes.MovieActivity.route +
                        "/${movies.indexOf(movie)}"
            )
        },
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.border(0.dp, contrastColor, RoundedCornerShape(0.dp))
    ) {
        InsideMovieCard(movie)
    }
}

@Composable
fun InsideMovieCard(movie: Movie) // Inside of a movie card
{
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShowImage(
            draw = movie._image, modifier = Modifier
                .width(100.dp)
                .padding(11.dp)
        )
        Column {
            DetailsMovie(movie)
        }
    }
}

@Composable
fun DetailsMovie(movie: Movie) // Details of a movie in home page
{
    Column {
        TextRoboto(text = movie._name, color = textColor, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        TextRoboto(text = movie._description, color = textColor)
        if (movie._seats_selected > 0) {
            TextRoboto(text = "Seats selected: ${movie._seats_selected}", color = selectedSeatColor)
        } else {
            if (movie._seats_remaining < 3) {
                RemainSeats(movie)
            } else {
                TextRoboto(text = "Seats remaining: ${movie._seats_remaining}", color = textColor)
            }
        }
    }
}

@Composable
fun RemainSeats(movie : Movie) // Seats remaining and Filling Fast
{
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        TextRoboto(text = "Seats remaining: ${movie._seats_remaining}", color = textColor,
            modifier = Modifier.padding(end = 5.dp))
        FillingFast()
    }
}

@Composable
fun FillingFast() // Filling Fast Badge
{
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End)
    {
        BoxText("Filling Fast", Color.Red,modifier = Modifier
            .background(Color.DarkGray, RoundedCornerShape(5.dp))
            .padding(top = 3.dp, bottom = 3.dp, start = 5.dp, end = 5.dp))
    }
}