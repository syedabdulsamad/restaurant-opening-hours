package com.abdulsamadsyed.restaurantopeninghours.transformer

import com.abdulsamadsyed.restaurantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import org.springframework.stereotype.Component

@Component
class OutputResultTransform {

    fun transformToOutput(weeklyOpeningHours: Map<DaysOfWeek, List<OpeningHoursDay>>): String {
        var outputString = ""
        DaysOfWeek.values().forEach {
            val openingHoursOfDay = weeklyOpeningHours.get(it)
            if (openingHoursOfDay == null) {
                outputString += "${it.displayName}: Closed\n"
            } else {
                outputString += "${it.displayName}: "
                openingHoursOfDay.forEachIndexed { index, openingHour ->
                    outputString += ("${openingHour.openingClosingTimeString}" + if (index % 2 == 0 && index < openingHoursOfDay.size - 1) " - " else if (index < openingHoursOfDay.size - 1) ", " else "")
                }
                outputString += "\n"
            }
        }
        return outputString.trim()
    }
}
