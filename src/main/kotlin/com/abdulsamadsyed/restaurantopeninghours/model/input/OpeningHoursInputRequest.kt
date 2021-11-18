package com.abdulsamadsyed.restaurantopeninghours.model.input

data class OpeningHoursInputRequest(
    val monday: List<OpeningHours>,
    val tuesday: List<OpeningHours>,
    val wednesday: List<OpeningHours>,
    val thursday: List<OpeningHours>,
    val friday: List<OpeningHours>,
    val saturday: List<OpeningHours>,
    val sunday: List<OpeningHours>
)
