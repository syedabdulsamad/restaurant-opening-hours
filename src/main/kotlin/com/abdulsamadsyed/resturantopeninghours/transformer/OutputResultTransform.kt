package com.abdulsamadsyed.resturantopeninghours.transformer

import com.abdulsamadsyed.resturantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
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
                    outputString += ("${openingHour.openingClosingTime}" + if (index % 2 == 0 && index < openingHoursOfDay.size - 1) " - " else if (index < openingHoursOfDay.size - 1) ", " else "")
                }
                outputString += "\n"
            }
        }
        return outputString
    }
}
