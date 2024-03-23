package com.stu74526.lab2_74526

val titles = listOf("Ready Player One", "Super Mario Bros", "The Maze Runner",
    "The Spiderwick Chronicles", "Enola Holmes 2")
val descriptions = listOf(
    "When the creator of a virtual reality called the OASIS dies, he makes a posthumous challenge to all OASIS users to find his Easter Egg.",
    "Two Brooklyn plumbers, Mario and Luigi, must travel to another dimension to rescue a princess from the evil dictator King Koopa",
    "Thomas is deposited in a community with only boys, where he becomes curious about some mysterious surroundings.",
    "Upon moving into the run-down Spiderwick Estate with their mother, Jared, Simon and their sister Mallory, find themselves pulled into an alternate world full of creatures.",
    "Enola Holmes, a teen detective on her own mission to solve a mystery where she must outsmart her big brother Sherlock.")
val images = listOf(
    R.drawable.readyplayerone_poster, R.drawable.supermariobros_poster,
    R.drawable.themazerunner_poster, R.drawable.thespiderwickchronicles_poster,
    R.drawable.enolaholmes_poster)
val certifications = listOf(
    Certification.A.value, Certification.PG.value, Certification.A.value,
    Certification.A.value, Certification.A.value)
val starrings = listOf(
    arrayOf("Tye Sheridan", "Olivia Cooke", "Ben Mendelsohn"),
    arrayOf("Bob Hoskins", "John Leguizamo", "Dennis Hopper"),
    arrayOf("Dylan O'Brien", "Kaya Scodelario", "Will Poulter"),
    arrayOf("Freddie Highmore", "Sarah Bolger", "David Strathairn"),
    arrayOf("Millie Bobby Brown", "Henry Cavill", "Sam Claflin"))
val timing = listOf(140, 92, 113, 96, 129)
fun randomNumber(): Int {
    return (1..15).random()
}


val movies: ArrayList<Movie> = ArrayList();

fun createMovies()
{
    for (i in 0..4)
    {
        movies.add(Movie(titles[i], images[i], certifications[i],
            descriptions[i], starrings[i], timing[i], randomNumber(), 0))
    }
}

fun initMovie()
{
    createMovies()
}

fun getMovieById(id: Int): Movie?
{
    for (i in movies.indices)
    {
        if (i == id)
        {
            return movies[i]
        }
    }
    return null
}