package com.abdulsamadsyed.resturantopeninghours.model

import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningHours
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import java.time.LocalTime

const val SECONDS_IN_HOUR = 3600
const val NOON_TIME = 12
const val AM = "AM"
const val PM = "PM"

class OpeningHoursDay(
    val day: DaysOfWeek,
    override val status: OpeningStatus,
    override val seconds: Int,
) : OpeningHours(status, seconds) {
    val openingClosingTime: String
        get() {
            val remainder = seconds % SECONDS_IN_HOUR
            val hours = (seconds / SECONDS_IN_HOUR)
            if (remainder != 0) { // opening closing time has booth hours and minutes component
                val minutes = remainder / 60
                return if (hours >= NOON_TIME) {
                    if (hours - NOON_TIME == 0) {
                        "$NOON_TIME:$minutes $PM"
                    } else {
                        "${hours - NOON_TIME}:$minutes" + " $PM"
                    }
                } else {
                    "$hours:$minutes $AM"
                } // AM hours with minutes
            } else { // opening closing time has only hours component
                return if (hours >= NOON_TIME) {
                    if (hours - NOON_TIME == 0) {
                        "$NOON_TIME $PM"
                    } else {
                        "${hours - NOON_TIME}" + " $PM"
                    }
                } else {
                    "$hours $AM"
                } // AM hours without minutes
            }
        }
}
