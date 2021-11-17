package com.abdulsamadsyed.resturantopeninghours.model

import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningHours
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import java.time.LocalTime

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
            val localTime = LocalTime.ofSecondOfDay(seconds.toLong())
            val hours = localTime.hour
            val minutes = localTime.minute
            val minutesStr = if(minutes > 0) { ":$minutes"} else {""}
            return if (hours >= NOON_TIME) {
                if (hours - NOON_TIME == 0) { // if time is in the noon hours
                    "12".plus(minutesStr).plus(" $PM") // NOON hours and add minutes as well
                } else {
                    "${hours - NOON_TIME}".plus(minutesStr).plus(" $PM") // else use the reminder part as hours
                }
            } else {
                "$hours".plus(minutesStr).plus(" $AM") // if hours are before 12 (NOON)
            }
        }
}
