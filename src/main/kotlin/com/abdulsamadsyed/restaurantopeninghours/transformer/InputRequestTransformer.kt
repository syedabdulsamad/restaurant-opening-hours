package com.abdulsamadsyed.restaurantopeninghours.transformer

import com.abdulsamadsyed.restaurantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHoursInputRequest
import org.springframework.stereotype.Component

@Component
class InputRequestTransformer {

    fun transformInput(inputRequest: OpeningHoursInputRequest): List<OpeningHoursDay> {
        val mondayHours = inputRequest.monday.map { OpeningHoursDay(DaysOfWeek.monday, it.status, it.seconds) }
        val tuesdayHours = inputRequest.tuesday.map { OpeningHoursDay(DaysOfWeek.tuesday, it.status, it.seconds) }
        val wednesdayHours = inputRequest.wednesday.map { OpeningHoursDay(DaysOfWeek.wednesday, it.status, it.seconds) }
        val thursdayHours = inputRequest.thursday.map { OpeningHoursDay(DaysOfWeek.thursday, it.status, it.seconds) }
        val fridayHours = inputRequest.friday.map { OpeningHoursDay(DaysOfWeek.friday, it.status, it.seconds) }
        val saturdayHours = inputRequest.saturday.map { OpeningHoursDay(DaysOfWeek.saturday, it.status, it.seconds) }
        val sundayHours = inputRequest.sunday.map { OpeningHoursDay(DaysOfWeek.sunday, it.status, it.seconds) }
        return listOf(mondayHours, tuesdayHours, wednesdayHours, thursdayHours, fridayHours, saturdayHours, sundayHours).flatten()
    }
}
