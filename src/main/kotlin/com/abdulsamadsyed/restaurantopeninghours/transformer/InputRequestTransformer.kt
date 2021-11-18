package com.abdulsamadsyed.restaurantopeninghours.transformer

import com.abdulsamadsyed.restaurantopeninghours.exceptionhandling.RequestFormatException
import com.abdulsamadsyed.restaurantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHoursInputRequest
import org.springframework.stereotype.Component

@Component
class InputRequestTransformer {

    fun transformInputRequest(inputRequest: OpeningHoursInputRequest): List<OpeningHoursDay> {
        val mondayHours = inputRequest.monday.map { OpeningHoursDay(DaysOfWeek.monday, it.status, it.seconds) }
        val tuesdayHours = inputRequest.tuesday.map { OpeningHoursDay(DaysOfWeek.tuesday, it.status, it.seconds) }
        val wednesdayHours = inputRequest.wednesday.map { OpeningHoursDay(DaysOfWeek.wednesday, it.status, it.seconds) }
        val thursdayHours = inputRequest.thursday.map { OpeningHoursDay(DaysOfWeek.thursday, it.status, it.seconds) }
        val fridayHours = inputRequest.friday.map { OpeningHoursDay(DaysOfWeek.friday, it.status, it.seconds) }
        val saturdayHours = inputRequest.saturday.map { OpeningHoursDay(DaysOfWeek.saturday, it.status, it.seconds) }
        val sundayHours = inputRequest.sunday.map { OpeningHoursDay(DaysOfWeek.sunday, it.status, it.seconds) }
        return verifyTransformedInput(
            listOf(
                mondayHours,
                tuesdayHours,
                wednesdayHours,
                thursdayHours,
                fridayHours,
                saturdayHours,
                sundayHours
            ).flatten()
        )
    }
    private fun verifyTransformedInput(transformedRequest: List<OpeningHoursDay>): List<OpeningHoursDay> {
        if (transformedRequest.size % 2 != 0) {
            throw RequestFormatException("Input request should equal number of opening and closing times.")
        }
        transformedRequest.chunked(2) {
            if (it.first().status == it.last().status) {
                throw RequestFormatException("Consecutive opening or closing entries for a restaurant.")
            }
        }
        return transformedRequest
    }
}
