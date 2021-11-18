package com.abdulsamadsyed.restaurantopeninghours.model

import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHours
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningStatus
import java.time.LocalTime

const val NOON_TIME = 12
const val AM = "AM"
const val PM = "PM"

class OpeningHoursDay(
    val day: DaysOfWeek,
    override val status: OpeningStatus,
    override val seconds: Int,
) : OpeningHours(status, seconds) {
    val openingClosingTimeString: String
        // it would have been much easier to use below code if the output could be 06:00 AM instead of 6 AM
        // localTime.format(DateTimeFormatter.ofPattern("hh:mm a"))
        get() {
            val localTime = LocalTime.ofSecondOfDay(seconds.toLong())
            val minutesStr = if (localTime.minute > 0) { ":${localTime.minute}" } else { "" }
            return if (localTime.hour >= NOON_TIME) {
                // if time is in the NOON hours
                if (localTime.hour - NOON_TIME == 0) { "12".plus(minutesStr).plus(" $PM") } // NOON hours and add minutes as well
                else { "${localTime.hour - NOON_TIME}".plus(minutesStr).plus(" $PM") } // else use the reminder part as hours
            } else { "${localTime.hour}".plus(minutesStr).plus(" $AM") } // if hours are before 12 (NOON)
        }
}
