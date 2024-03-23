package com.stu74526.lab2_74526

class Movie(name : String, image : Int, certification : Int, description : String,
            starring : Array<String>, running_time_mins : Int, seats_remaining : Int,
            seats_selected : Int)
{
    var _name: String = name
    var _image: Int = image
    var _certification: Int = certification
    var _description: String = description
    var _starring: Array<String> = starring
    var _running_time_mins: Int = running_time_mins
    var _seats_remaining: Int = seats_remaining
    var _seats_selected: Int = seats_selected

    fun setSeats(selected_seats: Int)
    {
        _seats_selected = selected_seats
        _seats_remaining -= selected_seats
    }

    fun resetSeats()
    {
        _seats_remaining += _seats_selected
        _seats_selected = 0
    }
}