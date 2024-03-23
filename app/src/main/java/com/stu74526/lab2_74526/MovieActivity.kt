package com.stu74526.lab2_74526


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var selectedSeat = 0;
var remainingSeat = 0;

@Composable
fun MovieScreen(navController: NavController, movieId: String?) {
    val movie = movieId?.toInt()?.let { getMovieById(it) }
    if (movie == null) {
        navController.navigate(Routes.HomePage.route)
        return
    }
    selectedSeat = movie._seats_selected
    remainingSeat = movie._seats_remaining
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        MainMovie(movie, navController)
        Credits()
    }
}

@Composable
fun Credits()
{
    Column()
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(contrastColor)
        )
        BoxText(
            "Images credit: http://www.impawards.com/",
            textColor, Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        )
    }
}

@Composable
fun MainMovie(movie: Movie, navController: NavController) {
    Column()
    {
        MoviePoster(movie = movie, navController = navController)
        BodyMovie(movie = movie)
    }
}


@Composable
fun MoviePoster(movie: Movie, navController: NavController) {
    Box()
    {
        ShowImageScale(
            draw = movie._image,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        BackButton(movie = movie, navController = navController)
    }
}

@Composable
fun BackButton(movie: Movie, navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Routes.HomePage.route)
            if (selectedSeat > 0) {
                movie.setSeats(selectedSeat)
            }
        },
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = Modifier
            .padding(0.dp)
            .height(40.dp)
            .width(40.dp),
        contentPadding = PaddingValues(0.dp)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.downarrow),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun BodyMovie(movie: Movie) {
    Column(modifier = Modifier.padding(11.dp)) {
        MainDetailMovie(movie)
        SecondDetailMovie(movie)
        SeatsMovieDetails(movie)
    }
}

@Composable
fun MainDetailMovie(movie: Movie) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        TextRoboto(
            text = movie._name.toUpperCase(), color = textColor,
            fontWeight = FontWeight.Bold, fontSize = 24.sp
        )
        ShowImage(
            draw = movie._certification, modifier = Modifier
                .size(35.dp)
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun SecondDetailMovie(movie: Movie) {
    Column(
        modifier = Modifier.padding(top = 10.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.Center
    )
    {
        RowText(
            textString = "Starring ",
            stextString = movie._starring.joinToString(),
        )
        RowText(
            textString = "Running Time ",
            stextString = "${movie._running_time_mins / 60} hr(s) ${movie._running_time_mins % 60} mins",
        )
    }
}

@Composable
fun RowText(
    textString: String,
    stextString: String
) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        TextRoboto(text = textString, color = textColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        TextRoboto(text = stextString, color = contractTextColor, fontSize = 14.sp)
    }
}

@Composable
fun SeatsMovieDetails(movie: Movie) {
    if (movie._seats_selected > 0) {
        TextSeats(
            "${movie._seats_selected} seat(s) selected ",
            selectedSeatColor, R.drawable.bluecouch
        )
    } else {
        TextRoboto(
            text = movie._description, color = textColor, fontSize = 16.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 15.dp)
        )

        SeatsRow()
    }
}

@Composable
fun TextSeats(textString: String, textColor: Color, draw: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(
            painter = painterResource(id = draw),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        TextRoboto(
            text = textString, color = textColor, fontSize = 20.sp,
            modifier = Modifier.padding(start = 7.dp)
        )
    }
}


fun selectSeat() {
    if (remainingSeat > 0) {
        remainingSeat--
        selectedSeat++
    }
}

fun unselectSeat() {
    if (selectedSeat > 0) {
        remainingSeat++
        selectedSeat--
    }
}

@Composable
fun SeatsRow() {
    val selectedSeats = remember { mutableIntStateOf(selectedSeat) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextRoboto(text = "Select Seats", color = textColor, fontSize = 20.sp)
        if (selectedSeats.value > 0) {
            ButtonSeats(
                {
                    unselectSeat()
                    selectedSeats.value = selectedSeat
                },
                R.drawable.minusselected
            )
        } else {
            ButtonSeats({}, R.drawable.minusunselected, false)
        }
        TextRoboto(text = "${selectedSeat}", color = textColor, fontSize = 20.sp)
        if (remainingSeat > 0) {
            ButtonSeats({
                selectSeat()
                selectedSeats.value = selectedSeat
            }, R.drawable.plusselected)
        } else {
            ButtonSeats({}, R.drawable.plusunselected, false)
        }
    }
    TextSeats("${remainingSeat} Seats Remaining", textColor, R.drawable.couch)
    if (remainingSeat < 3) {
        BadgeFillingFast()
    }
}

@Composable
fun BadgeFillingFast() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth())
    {
        BoxText(
            "Filling Fast", Color.Red, modifier = Modifier
                .background(Color.DarkGray, RoundedCornerShape(5.dp))
                .padding(top = 3.dp, bottom = 3.dp, start = 5.dp, end = 5.dp)
        )
    }
}


@Composable
fun ButtonSeats(
    onClick: () -> Unit, draw: Int, enabled: Boolean = true,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(0.dp)
            .height(30.dp)
            .width(30.dp)
            .padding(paddingValues),
        contentPadding = PaddingValues(0.dp),
        enabled = enabled
    ) {
        ShowImageScale(
            draw = draw,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}