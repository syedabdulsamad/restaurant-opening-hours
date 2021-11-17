package com.abdulsamadsyed.resturantopeninghours.service

import com.abdulsamadsyed.resturantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import org.springframework.stereotype.Service

@Service
class OpeningHoursService {
    fun getOpeningHours(openingHoursList: List<OpeningHoursDay>): Map<DaysOfWeek, List<OpeningHoursDay>> {
        var openingHours = openingHoursList.toMutableList() // copy list to temp for working
        var previousSundayOpening = openingHours.first().status == OpeningStatus.close // If Monday starts with closing
        var first: OpeningHoursDay? = null
        var last: OpeningHoursDay? = null
        if (previousSundayOpening) { // if Monday starts with closing then Sunday ends with opening
            first = openingHours.removeFirst() // store these and will be added in the end
            last = openingHours.removeLast()
        }
        val calculatedOpeningHours = openingHours.chunked(2) // get the elements in the pairs of opening and closing times
            .map {
                listOf(
                    it.first(), // handle the case when the opening hours go to multiple days
                    OpeningHoursDay(it.first().day, it.last().status, it.last().seconds)
                )
            }.flatten()
        return (
            if (previousSundayOpening) calculatedOpeningHours.plus( // add the elements that were stored before.
                listOf(last!!, OpeningHoursDay(last!!.day, first!!.status, first!!.seconds))
            ) else calculatedOpeningHours
            ).groupBy { it.day }
    }
}
